//menuju ke fungsi show_date() 1000 milidetik atau 1 detik kemudian
window.setTimeout(“show_date()”,1000);
 
function show_date(){
 
var tanggal = new Date();
 
document.getElementById(“tempat_tanggal”).innerHTML= tanggal.toLocaleTimeString();
 
//kembali ke awal fungsi show_date() 1000 milidetik atau 1 detik kemudian
setTimeout(“show_date”,1000);
}