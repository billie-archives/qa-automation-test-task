using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net.Http;
using System.Net.Http.Headers;
using Newtonsoft.Json;
using System.IO;

namespace Utils
{
    public class HttpClientCall
    {
        public ResponseDto[] GetAPI(string url, string id)
        {
            using (var client = new HttpClient())
            {
                try
                {
                    client.BaseAddress = new Uri(url);
                    client.DefaultRequestHeaders.Accept.Clear();
                    client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                    var responseApi = client.GetAsync(url + "/" + id).Result;
                    if (!responseApi.IsSuccessStatusCode)
                        throw new Exception("API Call Failed");
                    var formattedResponse =  responseApi.Content.ReadAsStringAsync().Result;
                    try
                    {
                        return JsonConvert.DeserializeObject<ResponseDto[]>(formattedResponse);
                    }
                    catch
                    {
                        var node= JsonConvert.DeserializeObject<ResponseDto>(formattedResponse);
                        return new ResponseDto[] { node };
                    }
                    
                }
                catch(Exception ex)
                {
                    throw ex;
                }
                

            }
        }
    }
}
