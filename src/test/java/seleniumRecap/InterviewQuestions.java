package seleniumRecap;

public class InterviewQuestions {
    /*
    1-What are the advantages an disadvantages of Selenium?
    ADVANTAGES:* free resource
               *has big community
               *It supports multiple languages and browsers
    DISADVANTAGES:*you cannot automate captcha,pictures,mobile apps etc...
                  *There is no direct call(customer service) for support
                  *It only automates WEb application(browser)
                  *It does not have any system to generate report,so we use external resaurces(testng,cucumber etc
________________________
      2-What type of testng can you automate with SElenium?
      *Regression
      *Smoke
      *Functional test(positive and negative testing)
________________________
      3-What are the best types you do not automate with Selenium?
      *Perfomance Testing(Jmeter--> it is not really hard to learn)
      *manual testing(captcha,pictures)
      *non-functional testing(stress testing,loading testing,perfomance...)
      *Adhoc(monkey) testing(random testing(manual)
________________________
      4-What is locator in Selenium?What type of locators do you use in your Framework?
      --->Locator is a way to find the elements from DOM(development tool/page)
      --->The locators that i am using in my framefork are:
      -->ID finds the elements with ID attribute
      -->NAme find elemnts with Name attribute
      -->ClassName -->find the element with ClassName attribute
      -->TagName finds the element with tagname
      -->linkText find the element with "a" tagname and "text"
      -->PartialLinkText-->find the element with "a" tagname and "partialText"
      -->CSS-->find the element with CSS(id # or class .)
      -->Xpath-->find the element with Xpath
________________________
      5-How do you handle dynamic elements in UI automation?(CVS** interview question)
      -->In my project, i have faced many dynamic elements during UI automation:
         >To handle this issue i did this:
         *I used parent-child relationship for the elements
         *I used different ways to locate the eleemnts(like following-sibling,
         preceding-sibling,contains and etc)
         *I found the element with different attribute which is not dynamic
________________________
      6-Difference between driver.get() and driver.navigate()?
      Navigate()--->it doesn't wait webelements to be loaded from page.It waits for only specific elements
      that you are looking from page)
      -->It has methods(to,refresh,forward)

      Get()--->It waits all the webelements from page to be loaded
      --> it doesn't have any methods
________________________
      7-Difference between driver.close() and driver.quit()?

      driver.close()-->it specifically closes window that your driver is pointing
      *-->It closes only one tab

      driver.quit(0-->it closes all the tabs that were oppened during the automation
________________________
      8-What is Xpath and can you tell me about types of Xpath?Which one do you use the most?
       8.1 whats the difference between Absolute and relative xpath?
      -->Xpath: is one the locators that i use in Selenium to find the element.
              There are 2 types of Xpath:
              1- Absolute:
                 it goes from all the way top(html) to child.
                 it starts with single slash (/)
              2-Relative:
                 it goes directly o child or parent/child
                 exmaple://div[@id='child']//a[.='child'](preceding-sibling or following siblings you can say as well)
                 it starts with doable slash(//)

      NOTE:I use definitely the relative xpath the most since it is more functional
      and effective to locate the elements.
________________________
       9-How do you handle drop-downs?(static or dynamic drop-down)
       In my project i was handling the drop-downs with different ways:
       I would definitely check the tag of the webElement(location)
         *If the location has "Select" tagName then i use Select class
         exp:Select select=new Select(location of webElement)
         * If the location doesn't have select tagName then
         I can use:
         --> Actions class methods like click or WebElemnts method click and choose
         -->or I would use SendKeys() to choose the option.
________________________
         10-Can you tell me what do you know about Select class and its methods?
         Select class is a way to handle dropdowns:

         -->It is really usefull in my project.
         -->the WebElement must have Select tagname
         There are some methods:
         Select select=new Select(location);
         *select.selectByvisibleText("textValue")
         *select.selectByIndex(indexNumber)
         *select.selectByValue("value")
         *select.select.getFirstSelectedOption()-->it will give you default option selected
         *select.getOptions()-->it will give you all options(List<String>)
________________________
         11-What is of exceptions have you faced in your automation Framework?
         -->NoSuchElemnt exception
         -->StaleElementReference exception
         -->ElementInetrcepted exception
         -->ElemnentIsNotInteractable
         -->No such window exception
         -->no such frame exception
         -->TestNg exception
         -->UnHAndled alert exeption
         -->Timout exeption
         -->Invalid selector exeption
________________________
         12-How do you handle Stale Element Reference Exeption?
         In my project,this exception is one of the hard ones that was giving me headache:

         -->This happens when:
         *DOm is not updated fast
         *DOM's eleemnt values is changed
         *The page is refreshed

         -->Wait times might solve the issue:
            -->I would use Thread.sleep or ExplicitlyWait with condition
            **-->I would reassign and reinitialixe the webelement
            -->I would refresh the page
________________________
         13-How do you handle pop-ups?

         There are different types of pop-ups that ive faced during autoomation?
         1-Operation system(os): we can not handle it directly with Selenium
         2--Html alert/pop-ups: I just need to find the element and click on it(like OK or Cancel Button)(inspectable)
         3-JavaScript alert: I handle it with Alert interface(non inspectable)
            Alert alert=driver.switchTo().alert();

            alert.accept()-->it click "OK" button from alert
            alert.dismiss()-->it clicks "cancel" button from alert
            alert.getText()-->it gets the text from alert
            alert.sendKeys()-->it sends the key to the alert
________________________
        14-What do you know about iFrame?and how do you handle this in your automation?
        -->iFrame is html inside html
        -->it nis used for protection
        -->It is widely used for Ads, documents or videos

        --> First switch your based on the value of WebElment:
        -->driver.switchTo.frame(id or name)
        -->driver.switchTo.frame(Webelement)
        -->driver.switchTo.frame(index)
        -->driver.switchTo.Parentframe()-->it will go to the parent frame
        -->driver.switchTo.defaultContent()-->it will no matter what go to the main html directly

        NOTE:If you do not handle this frame,you will get NoSuchElemnt exeption
        NOTE:If the value of switchFrame is wrong, you will get NoSuschFrame exeption
        15 - What do you know about Actions class? Can you tell me methods you use the most during the automation?

    Action class basically does the functionality of mouse it is really usefully in my automation
    to handle some elements. Methods are:

  **--> contextClick --> right click on the webElement
    --> DoubleClick
    --> DragAndDrop --> from one spot to another
    --> clickAndHold --> clicks and hold
    --> MoveToElement -->  it hover over the element
    --> release --> it releases  element you holds
    --> click
    --> sendKeys ()
 ***--> perform --> it performs action methods. Without it will not work

16 - What is a difference between driver.findElement/s ?

    Find element:  --> driver.findElement By locator
                   --> return single webElement
                   --> if fails : noSuchElement
    Find elements: --> driver.findElements By locator
                   --> returns List<WebElement>
                   --> if fails return empty list

17 - Can you tell me some drier and webElement methods you use during the automation mostly?

    Driver Methods: * get() *navigate() * getTitle() * getCurrentUrl()
                    * switchTo() * quit() * close() * GetWindowHandle/s () * Manage()

    WebElement Methods: * click() * sendKeys() * getText() * isDisplayed()
                        * isSelected() * getCssValue() * clear() * submit()* getAttribute()


18 - What is a difference between checkBox and radioButton?

    checkBox --> you can click multiple boxed with your button
    radioButton -->  you can choose only one. (circle)

19 - How do you handle multiple windows in automation? And what is a difference between getWindowHandle/s?

    To be able to handle windows:

    I need to switch my driver to specific window with my logic.

    Set<String> allWindows = driver.getWindowHandles();
    for(String pageID : allWindows ){
    driver.switchTo.Window(PageID);
    if(driver.getTitle.contains(expectedTitle)}
    break;

    1 - Use windowHandles to store all pages ID
    2 - Loop through all pages and switch
    3 - Break the loop when title is what im looking for

NOTE: getWindowHandle --> returns String single page ID
      getWindowHandles --> returns Set<String> with all unique pages IDs

20 - How do you scroll down or up in WebBrowser during the automation?

 ***--> I mostly use JS scrollIntoView script(I store it in my BrowserUtils for anytime usage)
    --> Actions.scrollByAmount (x,y)
    --> Keys.PageUp or Down --> all the way up or down
    --> Keys.ArrowUp or Down --> scroll by a little

21 - How do you upload file in Selenium.

    --> Fist of all you need to find a location of choose button.
    --> Find path of file that you're going to upload //c:desktop/file.png
    --> Send keys of the location to the choose button

22 - What is a difference between Asser and SoftAsser ?

    Assert: is a class that has some methods to validate actual and expected data
    Assert.assertEquals, assertTrue, asserFalse
    When it fails it throws exception right the way and stop executing code

    Soft Assert: class that has some methods and validate actual and expected data
    We need to create an object
    SoftAsser softAssert = new SoftAssert();
    When it fails it does not throw and exception and keeps executing next code
    ***You must use AssertAll() to make it work properly otherwise it will pass all the time

23 - Can you tell me about your Singleton Pattern Design? Can you make a constructor private, static, final?

    First of all I appreciate for this question since i sile singleton logic because in the past I was working on my driver and getting load
    of NULL POINTER exception. With the help of Singleton I centralized my driver with reduced the amount of exception
     I got with mean it is more reliable and safe to use

     --> I basically Encapsulate my Singleton

        --> I need to have a private WebDriver;
        --> I need to have Private Constructor
        --> Put if condition to check my driver is NULL or not
        --> create a public method to call from other class

24 - What kind of TestNG annotation do you use in you project? Can you tell me hat is purpose of the @Parameter

25 - What do you know about @DataProvider and why do you use it ?

26 - Wait do you know about WaitTimes and can you tell me the difference between Thread.speed , Implicitly-Explicitly-Fluent wait?











     */
}
