package by.anthony.model;

public class AppItem {
    private static final String OUT_CONST = "OUT_CONST";
    private String outInstance;

    public AppItem(String outInstance) {
        this.outInstance = outInstance;
    }

    public String getOutInstance() {
        return outInstance;
    }

    public void exampleAnonymous() {
        SumFunction sumFunction = new SumFunction() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        int a = 15;
        System.out.println("Anonymous class, result(8015): " + sumFunction.sum(a, 8000));
    }

    public void exampleNonCapturingLambda() {
        SumFunction sumFunction = (a, b) -> a * 4 + b * 4;
        System.out.println("Non Capturing Lambda in class method, result(32060): " + sumFunction.sum(15, 8000));
    }

    public void exampleCapturingLambda() {
        SumFunction sumFunction = (a, b) -> a * 2 + b * 2;
        int a = 15;
        int b = 8000;
        System.out.println("Capturing Lambda in class method, result(16030): " + sumFunction.sum(a, b));
    }

    public void exampleLocal() {
        class LocalTest {
            private String name;

            public LocalTest(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }
        }
        LocalTest localTest = new LocalTest("Name of Local class");
        System.out.println("Local class, name : " + localTest.getName());
    }

    public static class StaticNested {
        private static int STATIC_NESTED = 10;
        private int staticNested;

        public StaticNested(int staticNested) {
            this.staticNested = staticNested;
        }

        public String exampleStaticNested() {
            return new StringBuilder().append("Static Nested Class:")
                    .append("\n variables: static:\t").append(STATIC_NESTED)
                    .append("\t non-static: \t").append(staticNested)
                    .append("\n out_static_variable: \t").append(OUT_CONST)
                    .append("\t NOT see non-static variable")
                    .toString();
        }
    }

    public class Inner {
        private int inner;

        public Inner(int inner) {
            this.inner = inner;
        }

        public String exampleInner() {
            return new StringBuilder().append("Inner Class:")
                    .append("\n non-static variable: \t").append(inner)
                    .append("\t can't have static variable")
                    .append("\n out_static_variable: \t").append(OUT_CONST)
                    .append("\t non-static variable: \t").append(outInstance)
                    .toString();
        }
    }

}