import jwt.JwtRsaUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JwtRsaUtilsTest {

    private JwtRsaUtils jwtRsaUtils;
    private String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJpc3MiOiJhZXJvZGMifQ.4DZhFri0pq8pGM63XJjnylSIKR77cUMWZEDrhsukkFkTqEeWA-hJjK5BXjNdpVoTIvMHOLz9I4Jww0D4bpIQRfl19vjPXn4LtHqDnFSp5sn89NjLoGdUjkInbnmIKLDbPHT_LXEP5fOiADmM9KIQJxQFzMV7OWoMVyktau2BtXVQMWJzNDmN64KDq262sYB8Q5PBgHaL2hqSnpTRjDAlhnoLO9Kg-msQGYQRnxtNAgYf-ZgibYHH3XjRB3_m9oebPrUEzGd_cDpfMNe589HZXzkDy0P_QeK5_mcEceWeFfiWLdb8V5ke4NOxp47v1CYdpWPTyT2L4-_DvXLh1HUWRA";


    @Before
    public void setUp() throws Exception {
        jwtRsaUtils = new JwtRsaUtils();
    }

    @Test
    public void signTokenTest(){
        Assert.assertEquals(token, jwtRsaUtils.signToken());
    }

    @Test
    public void verifyTokenTest(){
        Assert.assertTrue(jwtRsaUtils.verifyToken(token));
    }
}
