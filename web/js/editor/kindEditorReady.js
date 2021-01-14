//KindEditor.ready(function(K) {
//        window.editor = K.create('#new_message');
//});
KindEditor.ready(function(K) {
        K.create('#new_message', {
        	//upload_json.jsp是上传文件程序,此处的路径需要依据你的网页编辑器editior所在页面的目录位置进行设置调用路径uploadJson的值
                uploadJson : '../../js/editor/jsp/upload_json.jsp',  
                //uploadJson : '../js/editor/jsp/upload_json.jsp',
                //uploadJson : 'editor/jsp/upload_json.jsp'
                // fileManagerJson : '../jsp/file_manager_json.jsp',
                allowFileManager : true
        });
});
var options = {
cssPath : '/css/index.css',
filterMode : true
};
var editor = K.create('textarea[name="message"]', options);
// 取得HTML内容
html = editor.html();
// 同步数据后可以直接取得textarea的value
editor.sync();
html = document.getElementById('new_message').value; // 原生API
html = K('#new_message').val(); // KindEditor Node API
html = $('#new_message').val(); // jQuery
// 设置HTML内容
editor.html('HTML内容');
// 关闭过滤模式，保留所有标签
KindEditor.options.filterMode = false;
KindEditor.ready(function(K) {
        K.create('#new_message');
});
