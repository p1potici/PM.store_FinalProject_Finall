package Object.Models;

public class RegistrationUserModel {
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String confirmPassword;

    public RegistrationUserModel(String email, String firstName, String lastName, String password, String confirmPassword) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }
    public String getEmail() {
        return email;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPassword() {
        return password;
    }
    public String getConfirmPassword() {
        return confirmPassword;
    }
}
