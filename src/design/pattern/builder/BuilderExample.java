package design.pattern.builder;

import design.pattern.builder.User.UserBuilder;

public class BuilderExample {

    public static void main(String[] args) {

        // We cannot create object for user. This is because user constructor is
        // made private for making it immutable
        UserBuilder builder = new UserBuilder("userId", "pwd").age(12).fName("fName").lName("lName").sex("M");
        User user = builder.build();

        UserBuilder invalidBuilder = new UserBuilder("userId", "pwd").age(23).sex("N");
        User invalidUser = invalidBuilder.build();

    }

}
