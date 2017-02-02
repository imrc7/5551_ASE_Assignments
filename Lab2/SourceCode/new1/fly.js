/**
 * Created by revan on 1/29/2017.
 */

function home()
    {
    if(document.getElementById("name").value === '' || document.getElementById("name").value === null ||document.getElementById("email").value === '' || document.getElementById("email").value === null || document.getElementById("username").value === '' || document.getElementById("username").value === null ||  document.getElementById("password").value === '' || document.getElementById("password").value === null || document.getElementById("confirm").value === '' || document.getElementById("confirm").value === null)
    {
        alert('Dear User: Please enter all the details');
    }

    else if
        (document.getElementById("password").value != document.getElementById("confirm").value)
        {
            alert("Password and Confirm password should match");
        }
 else
     {

         localStorage.setItem("actualname", document.getElementById("name").value);
         localStorage.setItem("email", document.getElementById("email").value);
         localStorage.setItem("username", document.getElementById("username").value);
         localStorage.setItem("password", document.getElementById("password").value);
         localStorage.setItem("password_confirm", document.getElementById("confirm").value);

      window.location="login.html";
     }
}
function login()
{
    var a = localStorage.getItem("email");
    var b = localStorage.getItem("password");

    if ((a==document.getElementById("email-input").value)&& (b==document.getElementById("password-input").value))
    {
        userName = localStorage.getItem("username");
        window.location = "home.html";
    }
    else if(document.getElementById("email-input").value === '' || document.getElementById("email-input").value === null || document.getElementById("password-input").value === '' || document.getElementById("password-input").value === null)
    {
        alert('Please enter the login details');
    }

else

            window.alert("Dear USER: Login failed. Invalid email or password");

}

function validation()
{
    var x = document.forms["myForm"]["name"].value;
    if (x == "") {
        alert("Name must be filled out");
        return false;
    }
}

function signout()
{
    window.location = "signout.html";
}

function backtologin() {

    window.location = "login.html";
}