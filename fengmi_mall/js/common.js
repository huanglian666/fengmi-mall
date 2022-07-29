//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
         }
         if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
         }
     }
    return "";
} 


axios.defaults.timeout = 5000;   // 超时时间
axios.defaults.baseURL = "http://localhost:7777";  // baseURL
//请求拦截器
axios.interceptors.request.use(function(config){
    console.log(config)
    config.withCredentials= false 
    //设置jwt令牌
    config.headers.token=getCookie("token")//sessionStorage.getItem("token")
    return config;
})
 //响应拦截器
axios.interceptors.response.use(res=>{
    return res.data;
})	


const  fengmi = {

    //解析url获取参数值
    getUrlRequest: function (name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"), // 构造一个含有目标参数的正则表达式对象
			r = decodeURIComponent(window.location.search).substr(1).match(reg); // 匹配目标参数
		// 返回参数值
		if (r != null) {
			return decodeURIComponent(r[2]);
			// return unescape(r[2]);
		}
		return null;
    },
    pageTotal(total, size) {//计算总页数  
        if(total==null || total==""){
                return 0; 
        }else{
            if(size !=0 && total%size == 0){
                return parseInt(total / size);
            }
            if(size != 0 && total % size != 0) {
                return parseInt(total / size) + 1;
            }
        }
    },
    http: axios
}