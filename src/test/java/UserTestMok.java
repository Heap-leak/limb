import com.limb.objmodels.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTestMok {
    @Test
    public void createUser(){
        User user = new User("test", "test");
        Assert.assertNotNull(user);
    }


}
