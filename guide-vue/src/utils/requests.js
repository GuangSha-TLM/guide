import axios from "axios";
import VueCookie from 'vue-cookie';

const http = axios.create({
    timeout: 1000*30,
    withCredentials: true,
    headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
})
 
 /**
 * 请求拦截
 * @param {*} params 
 * @param {*} openDefultParams 
 * @returns 
 */
http.interceptors.request.use(config => {
    let token = VueCookie.get("token");
    //设置请求头
    config.headers['Authorization'] = token;
    config.headers['accept'] = '*/*'

    return config;
})


/**
 * 响应拦截
 * @param response 响应数据
 */
http.interceptors.response.use(response => {
    console.log(response,"response")
    return response;
}, error => {
    // 检查错误是否为401
    if (error.response && error.response.status === 401) {
        //删除token
        VueCookie.delete('token')
        // console.log(this.$cookie.get('token'));
    }
    return Promise.reject(error);
});

 
// /**
//  * get请求参数处理
//  * params 参数对象
//  * openDefultParams 是否开启默认参数
//  */
// http.adornParams = (params = {}, openDefultParams = true) => {
//     var defaults = {
//         t: new Date().getTime()
//     }
//     return openDefultParams ? merge(defaults, params) : params
// }

// /**
//  * post请求数据处理
//  * @param {*} data 数据对象
//  * @param {*} openDefultdata 是否开启默认数据?
//  * @param {*} contentType 数据格式
//  *  json: 'application/json; charset=utf-8'
//  *  form: 'application/x-www-form-urlencoded; charset=utf-8'
//  */
// http.adornData = (data = {}, openDefultdata = true, contentType = 'json') => {
//     var defaults = {
//         t: new Date().getTime()
//     }

//     data = openDefultdata ? merge(defaults, data) : data
//     return contentType === 'json' ? JSON.stringify(data) : qs.stringify(data)
// }

// // /**
// //  * windPost请求
// //  * @param {String} url [请求地址]
// //  * @param {Object} params [请求携带参数]
// //  */
// // http.windPost = function (url, params) {
// //     return new Promise((resolve, reject) => {
// //         http.post(http.adornUrl(url), qs.stringify(params))
// //             .then(res => {
// //                 resolve(res.data)
// //             })
// //             .catch(error => {
// //                 reject(error)
// //             })
// //     })
// // }


// /**
//  * windGet请求
//  * @param {String} url [请求地址]
//  * @param {Object} params [请求携带参数]
//  */
// http.windGet = function (url, params) {
//     return new Promise((resolve, reject) => {
//         http.get(http.adornUrl(url), { params: params })
//             .then(res => {
//                 resolve(res.data)
//             })
//             .catch(error => {
//                 reject(error)
//             })
//     })
// }

// /**
//  * 上传图片
//  */
// http.upLoadPhoto = function (url, params, callback) {
//     let config = {}
//     if (callback !== null) {
//         config = {
//             onUploadProgress: function (progressEvent) {
//                 //属性lengthComputable主要表明总共需要完成的工作量和已经完成的工作是否可以被测量
//                 //如果lengthComputable为false，就获取不到progressEvent.total和progressEvent.loaded
//                 callback(progressEvent)
//             }
//         }
//     }
//     return new Promise((resolve, reject) => {
//         http.post(http.adornUrl(url), http.adornParams(params), config)
//             .then(res => {
//                 resolve(res.data)
//             })
//             .catch(error => {
//                 reject(error)
//             })
//     })
// }



export default http