
package finalprojectB;

import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {



   public UrlValidatorTest(String testName) {
      super(testName);
   }

   ResultPair[] testUrlScheme = {new ResultPair("http://", true),
           new ResultPair("ftp://", true),
           new ResultPair("http://", true),
           new ResultPair("https:", false),
           new ResultPair("", true)
   };

   ResultPair[] testUrlAuthority = {new ResultPair("www.google.com", true),
           new ResultPair("0.0.0.0", true),
           new ResultPair(null, false),

   };

   ResultPair[] testUrlPort = {new ResultPair(":::", false),
           new ResultPair("", true),
           new ResultPair(":-1", false),
   };

   ResultPair[] testPath = {
           new ResultPair("/..", false),
           new ResultPair("/../", false),
           new ResultPair("/test1/", true),
           new ResultPair("", true),
           new ResultPair("/test1/file", true),
   };

   ResultPair[] testUrlQuery = {new ResultPair("?action=view", true),
           new ResultPair("?action=edit&mode=up", true),
           new ResultPair("", true)
   };





   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
      System.out.print("\n testIsValidScheme() ");

      String[] schemes = {"http", "https"};
      //UrlValidator urlVal = new UrlValidator(schemes,false,false,false);
      UrlValidator urlVal = new UrlValidator(schemes, UrlValidator.ALLOW_ALL_SCHEMES);
      for (int sIndex = 0; sIndex < schemes.length; sIndex++) {
         ResultPair testPair = new ResultPair(schemes[sIndex],true);
         boolean result = urlVal.isValidScheme(testPair.item);
         assertEquals(testPair.item, testPair.valid, result);

      }

      //System.out.print("\n testIsValid");


      assertTrue(urlVal.isValid("http://www.google.com:80/test1?action=view"));
      assertTrue(urlVal.isValidScheme("http"));
      assertFalse(urlVal.isValid("http://www.google.com:80/test1?action=viewhttp://www.google.com:80/test1?action=viewhttp://www.google.com:80/test1?action=view"));
      assertFalse(urlVal.isValidPath("/./"));
      assertFalse(urlVal.isValid(null));

   }
   
   
   public void testYourFirstPartition()
   {
      ResultPair[] schemes = {new ResultPair("ftp://", true),new ResultPair("hello", false)};
      ResultPair[] authority = {new ResultPair("www.gmail.com", true), new ResultPair(null, false)};
      ResultPair[] port = {new ResultPair(":0", true), new ResultPair(":82b", false)};
      ResultPair[] path = {new ResultPair("/file", true), new ResultPair("/file//file2", false)};
      ResultPair[] query = {new ResultPair("?action=edit",true), new ResultPair("sfvsefbfdvc", false)};

      StringBuilder buildstr1 = new StringBuilder();

      buildstr1.append(schemes[0]);
      buildstr1.append(authority[0]);
      buildstr1.append(port[0]);
      buildstr1.append(path[0]);
      buildstr1.append(query[0]);

      UrlValidator urlVal = new UrlValidator(null, null,UrlValidator.ALLOW_ALL_SCHEMES);

      String url = buildstr1.toString();
      assertTrue(urlVal.isValid(url));

      StringBuilder buildstr2 = new StringBuilder();

      buildstr2.append(schemes[0]);
      buildstr2.append(authority[0]);
      buildstr2.append(port[0]);
      buildstr2.append(path[0]);
      buildstr2.append(query[1]);

      String url2 = buildstr2.toString();
      assertFalse(urlVal.isValid(url2));

      String query1 = query[1].toString();
      assertFalse(urlVal.isValidQuery(query1));

	 //You can use this function to implement your First Partition testing


   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   
      ResultPair[] schemes = {new ResultPair("ftp://", true),new ResultPair("hello", false)};
      ResultPair[] authority = {new ResultPair("www.gmail.com", true), new ResultPair(null, false)};
      ResultPair[] port = {new ResultPair(":0", true), new ResultPair(":82b", false)};
      ResultPair[] path = {new ResultPair("/file", true), new ResultPair("/file//file2", false)};
      ResultPair[] query = {new ResultPair("?action=edit",true), new ResultPair("sfvsefbfdvc", false)};

      StringBuilder buildstr1 = new StringBuilder();

      buildstr1.append(schemes[1]);
      buildstr1.append(authority[1]);
      buildstr1.append(port[1]);
      buildstr1.append(path[1]);
      buildstr1.append(query[1]);

      UrlValidator urlVal = new UrlValidator(null, null,UrlValidator.ALLOW_ALL_SCHEMES);

      String url = buildstr1.toString();
      assertFalse(urlVal.isValid(url));

      StringBuilder buildstr2 = new StringBuilder();

      buildstr2.append(schemes[0]);
      buildstr2.append(authority[0]);
      buildstr2.append(port[0]);
      buildstr2.append(path[1]);
      buildstr2.append(query[0]);

      String url2 = buildstr2.toString();
      assertFalse(urlVal.isValid(url2));

      String path1 = path[1].toString();
      assertFalse(urlVal.isValidPath(path1));
   }

   public void partition3(){
      ResultPair[] schemes = {new ResultPair("ftp://", true),new ResultPair("hello", false)};
      ResultPair[] authority = {new ResultPair("www.gmail.com", true), new ResultPair(null, false)};
      ResultPair[] port = {new ResultPair(":0", true), new ResultPair(":82b", false)};
      ResultPair[] path = {new ResultPair("/file", true), new ResultPair("/file//file2", false)};
      ResultPair[] query = {new ResultPair("?action=edit",true), new ResultPair("sfvsefbfdvc", false)};

      UrlValidator urlVal = new UrlValidator(null, null,UrlValidator.ALLOW_ALL_SCHEMES);

      StringBuilder buildstr2 = new StringBuilder();

      buildstr2.append(schemes[0]);
      buildstr2.append(authority[0]);
      buildstr2.append(port[1]);
      buildstr2.append(path[0]);
      buildstr2.append(query[0]);

      String url2 = buildstr2.toString();
      assertFalse(urlVal.isValid(url2));

      String port1 = port[1].toString();
      assertFalse(urlVal.isValidPath(port1));
   }

   public void partition4(){
      ResultPair[] schemes = {new ResultPair("ftp://", true),new ResultPair("hello", false)};
      ResultPair[] authority = {new ResultPair("www.gmail.com", true), new ResultPair(null, false)};
      ResultPair[] port = {new ResultPair(":0", true), new ResultPair(":82b", false)};
      ResultPair[] path = {new ResultPair("/file", true), new ResultPair("/file//file2", false)};
      ResultPair[] query = {new ResultPair("?action=edit",true), new ResultPair("sfvsefbfdvc", false)};

      UrlValidator urlVal = new UrlValidator(null, null,UrlValidator.ALLOW_ALL_SCHEMES);

      StringBuilder buildstr = new StringBuilder();

      buildstr.append(schemes[0]);
      buildstr.append(authority[1]);
      buildstr.append(port[0]);
      buildstr.append(path[0]);
      buildstr.append(query[0]);

      String url = buildstr.toString();
      assertFalse(urlVal.isValid(url));

      String auth1 = authority[1].toString();
      assertFalse(urlVal.isValidPath(auth1));
   }
//

   public void testIsValid() {
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      boolean expected = true;
      int[] testIndex = {0, 0, 0, 0,0};
      Object[] testUrlParts = {testUrlScheme, testUrlAuthority, testUrlPort, testPath, testUrlQuery};
      ResultPair[] part;

      for (int i = 0; i < 3; i++) {
         StringBuilder testBuffer = new StringBuilder();
         for (int testPartsIndexIndex = 0; testPartsIndexIndex < testIndex.length; testPartsIndexIndex++) {
            int index = testIndex[testPartsIndexIndex];
            part = (ResultPair[]) testUrlParts[testPartsIndexIndex];
            testBuffer.append(part[index].item);
            expected = expected && part[index].valid;
         }
         //String string1 = part



         String url = testBuffer.toString();
         boolean result = urlVal.isValid(url);

         assertEquals(url, expected, result);

      }

   }
}


   



