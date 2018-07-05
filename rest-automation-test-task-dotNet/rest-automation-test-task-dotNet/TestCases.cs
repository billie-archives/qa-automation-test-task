using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Web.Configuration;
using Utils;

namespace rest_automation_test_task_dotNet
{
    [TestClass]
    public class TestCases
    {
        public static string Url = WebConfigurationManager.AppSettings["URL"];
        public static ResponseDto[] response;

        //Call API to Get All Data before Run Class
        [ClassInitialize]
        public static void ClassInitializing(TestContext testContext)
        {
            response = new HttpClientCall().GetAPI(Url, string.Empty);
        }

        [TestMethod, TestCategory("Id")]
        public void CheckThatPostWithId_40_IsExist_byParamterInCall()
        {
            //Call API with specific Id
            var response = new HttpClientCall().GetAPI(Url, "40");

            Assert.IsTrue(response.Length >= 1 , "Post With Id [ 40 ] Exists " + response.Length + " times");
        }

        [TestMethod, TestCategory("PostId")]
        public void CheckThatPostId_40_IsExist_5Times()
        {
            //define variable to count how many posts with postId =40
            var commentCount = 0;
            foreach (ResponseDto node in response)
            {
                if (node.postId == "40")
                    commentCount++;
            }
            Assert.AreEqual(5, commentCount, "Post Id [ 40 ] Exists " + response.Length + " times not 5 as Expected");
        }

        [TestMethod, TestCategory("Id")]
        public void CheckThatPostWithId_40_IsExist_5Times()
        {
            //define variable to count how many posts with postId =40
            var commentCount = 0;
            foreach (ResponseDto node in response)
            {
                if (node.id == "40")
                    commentCount++;
            }
            Assert.AreEqual(5, commentCount, "Post Id [ 40 ] Exists " + response.Length + " times not 5 as Expected");
        }

        [TestMethod, TestCategory("PostId")]
        public void CheckThatPostId_40_hasSpecificData()
        {
            //define variable to check post with postId =40 include specific data
            var commentCount = 0;
            foreach (ResponseDto node in response)
            {
                if (node.postId.Equals("40"))
                    if (node.name.Equals("pariatur aspernatur nam atque quis"))
                        if (node.email.Equals("Cooper_Boehm@damian.biz"))
                            if (node.body.Equals("veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla"))
                                commentCount++;
            }
            Assert.IsTrue(commentCount >= 1, "Data is Not Matched with any Comment");
        }

        [TestMethod, TestCategory("Id")]
        public void CheckThatPostWithId_40_hasSpecificData()
        {
            //define variable to check post with Id =40 include specific data
            var commentCount = 0;
            foreach (ResponseDto node in response)
            {
                if (node.id.Equals("40"))
                    if (node.name.Equals("pariatur aspernatur nam atque quis"))
                        if (node.email.Equals("Cooper_Boehm@damian.biz"))
                            if (node.body.Equals("veniam eos ab voluptatem in fugiat ipsam quis\nofficiis non qui\nquia ut id voluptates et a molestiae commodi quam\ndolorem enim soluta impedit autem nulla"))
                                commentCount++;
            }
            Assert.IsTrue(commentCount >= 1, "Data is Not Matched with any Comment");
        }

        
    }
}
