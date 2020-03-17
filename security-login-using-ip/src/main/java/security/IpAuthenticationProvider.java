package security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lin
 * @version v 0.1 2020/3/12
 **/
public class IpAuthenticationProvider implements AuthenticationProvider {

    final static Map<String, SimpleGrantedAuthority> ipAuthorityMap = new ConcurrentHashMap<>(10);

    static {
        ipAuthorityMap.put("127.0.0.1", new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        IpAuthenticationToken token = (IpAuthenticationToken) authentication;
        String ip = token.getIp();
        SimpleGrantedAuthority simpleGrantedAuthority = ipAuthorityMap.get(ip);
        if (null == simpleGrantedAuthority) {
            return null;
        } else {
            return new IpAuthenticationToken(Arrays.asList(simpleGrantedAuthority), ip);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return IpAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
