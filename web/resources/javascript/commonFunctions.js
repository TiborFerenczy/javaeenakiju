/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


function checkPassword(form) {
var password = form[form.id + ":password1"].value;
var passwordConfirm = form[form.id + ":password2"].value;
if (password == passwordConfirm)
form.submit();
else
alert("Zawartoœæ pól musi byæ taka sama");
}