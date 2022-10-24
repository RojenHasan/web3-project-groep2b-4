package domain.service;


import domain.model.User;


import java.util.ArrayList;

public class UserServiceInMemory implements UserService{
    private static ArrayList<User> users = new ArrayList<>();

    private int sequence= 0;
    public UserServiceInMemory() {
        this.addUser(new User( "rojen.hasan@student.ucll.be", "1234","Rojen", "Hasan", "alpha", "director"));
        this.addUser(new User( "a14alrawi@gmail.com", "123","Abdullah", "Alrawe", "beta", "teamleader"));
    }


    public User getUserFromId(int id) {
       for(User u: users){
           if(u.getUserid() == id){
               return u;
           }
       }return null;
    }

    public void addUser(User user) {
        if (user == null)
            throw new IllegalArgumentException("User can't be empty");
        if (findUserWithEmail(user.getEmail())){
            throw new IllegalArgumentException("User already exists");
        }
        sequence++;
        user.setUserid(sequence);
        users.add(user);

    }

    private boolean findUserWithEmail(String email) {
        if (email == null || email.isEmpty())
            throw new IllegalArgumentException("Email can't be empty");
        for (User user : users) {
            if (user.getEmail().equals(email))
                return true;
        }
        return false;
    }

    public ArrayList<User> getAll() {
        return users;
    }

    public User getUserIfAuthenticated(String email, String password)
    {
        for(User user: users){
            if(user.getEmail().equals(email)){
                if(user.isCorrectPassword(password)){
                    return user;
                }else {
                    break;
                }

            }
        }
        throw new IllegalArgumentException("email or password is not correct");
    }

    public void delete(int id) {
        users.removeIf(user -> user.getUserid() == id);
    }


    public void edit(User newUser) {
        for(User u: users){
            if(u.getUserid() != newUser.getUserid()){
                if(u.equals(newUser))
                throw new IllegalArgumentException("already exist");
            }
        }

        for (User user : users) {
            if (user.getUserid() == newUser.getUserid()){
                user.update(newUser);
                break;
            }
        }

    }

}
