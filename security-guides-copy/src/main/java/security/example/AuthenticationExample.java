package security.example;

import org.springframework.security.authentication.AuthenticationManager;

/**
 * @author lin
 */
public class AuthenticationExample {

    private static AuthenticationManager authenticationManager = new SampleAuthenticationManager();

//    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//
//        while (true) {
//            System.out.println("Please enter your username:");
//            String name = in.readLine();
//            System.out.println("Please enter your password:");
//            String password = in.readLine();
//
//            try {
//                Authentication request = new UsernamePasswordAuthenticationToken(name, password);
//                Authentication result = authenticationManager.authenticate(request);
//                SecurityContextHolder.getContext().setAuthentication(result);
//            } catch (BadCredentialsException e) {
//                System.out.println("Authentication failed:" + e.getMessage());
//                continue;
//            }
//            System.out.println("Successfully authenticated. Security context contains:" + SecurityContextHolder.getContext().getAuthentication());
//        }
//    }
}
