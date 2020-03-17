package security;

import lombok.Data;
import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author lin
 * @version v 0.1 2020/3/12
 **/
@Getter
public class IpAuthenticationToken extends AbstractAuthenticationToken {

    /**
     * ip
     */
    private String ip;

    /**
     * Creates a token with ip
     *
     * @param ip ip
     */
    public IpAuthenticationToken(String ip) {
        super(null);
        this.ip = ip;
        super.setAuthenticated(false);
    }

    /**
     * Creates a token with the supplied array of authorities and ip.
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     * @param ip ip
     */
    public IpAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String ip) {
        super(authorities);
        this.ip = ip;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }
}
