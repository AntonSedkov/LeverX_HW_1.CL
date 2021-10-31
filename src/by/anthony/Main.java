package by.anthony;

import by.anthony.model.AppItem;
import by.anthony.model.User;
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        User user;
        if (args.length == 2 && !StringUtils.isBlank(args[0]) && StringUtils.isNumeric(args[1])) {
            user = new User(StringUtils.upperCase(args[0]), Integer.parseInt(args[1]));
        } else {
            String name = StringUtils.upperCase("Default Ivanovich");
            user = new User(name, 17);
        }
        System.out.println(user.toString());

        User guest = new User("First One", 10);
        Comparator<User> comparator = Comparator.comparingInt(User::getAge);
        List<User> sortedUsers = Stream.of(user, guest).sorted(comparator).collect(Collectors.toList());
        System.out.println(sortedUsers);

        AppItem appItem = new AppItem("TestClassName");
        System.out.println(appItem.getOutInstance());
        appItem.exampleAnonymous();
        appItem.exampleNonCapturingLambda();
        appItem.exampleCapturingLambda();
        appItem.exampleLocal();
        System.out.println(appItem.new Inner(9999).exampleInner());
        System.out.println(new AppItem.StaticNested(100).exampleStaticNested());
    }
}
