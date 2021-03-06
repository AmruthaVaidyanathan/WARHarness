# WARHarness
## Web Application Regression Harness
RESTful Web service

## Description
WARHarness is a tool which can be used for constructing a test harness for a given web application page. Provided a web page url, 
the tool will be able to parse the page and provide back a minimal set of Selenium powered test cases which can be used for testing 
the overall experience of the web page. 

# Testing
## 1
```bash
curl -H "x-cityu-client: WARHarnessWebUI" \
    -H "Accept: CrawlAPI/v1" \
    -d "{'url': 'https://www.google.com'}"
   "http://localhost:8080/WARHarness/api"
```

## 2
```bash
curl -H "x-cityu-client: WARHarnessWebUI" -H "Accept: CrawlAPI/v1" "http://localhost:8080/WARHarness/api?url=https://www.glassdoor.com/"
```

Output:
```bash
{"source":"

public class GlassdoorJobSearchFindTheJobThatFitsYourLife
{

        WebElement emailOptOut;
        WebElement userOriginHook;
        WebElement gdToken;
        WebElement userEmail;
        WebElement postLoginUrl;
        WebElement userPassword;

        @Test
        public void GdbtnGdbtn1Minwidthbtn() {
        }

        @Test
        public void GoogleGdbtnShort() {
        }

        @Test
        public void DefaultbuttonFacebookGdbtnCenterShort() {
        }

        @Test
        public void LockedhomesignupGdbtnGdbtnbuttonGdbtn1GdbtnmedGradient() {
        }

}

"}
```