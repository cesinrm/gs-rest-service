package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping(value="/IBMDomainVerification.html", method=RequestMethod.GET, produces="text/plain")
    public @ResponseBody String ibmDomainVerification() {
        return "<html><div id=\"verificationcode\" value=\"6b9f6383-4abd-6cc7-a6af-8ffb14b292c7\"></div>IBM Application Security on Cloud verification file<br>=================================<br><br>============================<br>Important: Do not edit this file in any way!<br>============================<br><br>This file is required in order to verify your permission to scan a domain with IBM Application Security on Cloud.<br>The file must be accessible to Application Security on Cloud each time you scan.<br><br>To use this file, please do the following:<br><br>1) Save this file in the root folder of the site you want to scan.<br><br>2) Return to IBM Application Security on Cloud and do one of the following:<ul><li>If you see the \"Great, let's verify\" page: Click the Verify button, and follow the online instructions to start the scan.</li><li>If you are asked to log-in: Start a new scan, enter the Starting URL of the domain where you have saved this file, and follow the online instructions to start the scan.</li></ul>When Application Security on Cloud detects this file in the root folder, the scan will be allowed to proceed.<br><br>If you experience any difficulties, please contact Support at:<br><a href='https://appscan.ibmcloud.com/ScanUI/SCX/contactSupport'>https://appscan.ibmcloud.com/ScanUI/SCX/contactSupport</a></html>";
    }

}
