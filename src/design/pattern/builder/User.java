package design.pattern.builder;

/**
 * User will be an immutable class and builder helps to construct the User
 * class. Builder pattern helps to make sure User object will never be in an
 * inconsistent state. If we use setters and set the values, then at the time of
 * object creation we can say that object is in inconsistent state
 * 
 * @author karthik
 *
 */
public class User {

    private String fName;
    private String lName;
    private Integer age;
    private String sex;
    private String userId;
    private String pwd;

    private User(UserBuilder builder) {
        this.fName = builder.fName;
        this.lName = builder.lName;
        this.age = builder.age;
        this.sex = builder.sex;
        this.userId = builder.userId;
        this.pwd = builder.pwd;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getUserId() {
        return userId;
    }

    public String getPwd() {
        return pwd;
    }

    public static class UserBuilder {

        private String fName;
        private String lName;
        private Integer age;
        private String sex;
        private String userId;
        private String pwd;

        public UserBuilder(String userId, String pwd) {
            this.userId = userId;
            this.pwd = pwd;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder sex(String sex) {
            this.sex = sex;
            return this;
        }

        public UserBuilder fName(String fName) {
            this.fName = fName;
            return this;
        }

        public UserBuilder lName(String lName) {
            this.lName = lName;
            return this;
        }

        public User build() {
            if (!this.sex.equalsIgnoreCase("M") || !this.sex.equalsIgnoreCase("F")) {
                throw new IllegalArgumentException("Please provide a valid sex");
            }
            User user = new User(this);
            return user;
        }

        /**
         * This method is thread safe because validation is done after the user
         * object is created
         * 
         * If validation is done before the user object creation, then there are
         * chances some other thread can change the values of sex and thereby
         * this validation is broken here
         * 
         * @return
         */
        public User buildThreadSafe() {
            User user = new User(this);
            if (!this.sex.equalsIgnoreCase("M") || !this.sex.equalsIgnoreCase("F")) {
                throw new IllegalArgumentException("Please provide a valid sex");
            }
            return user;

        }

    }

}
