/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function btn1Action()
{
    var span = document.getElementById("showOrHideSpan");
    var btn3 = document.getElementById("btn3");
    btn3.value = "Hide";
    span.style.display = 'block';
}

function btn2Action()
{
    var span = document.getElementById("showOrHideSpan");
    var btn3 = document.getElementById("btn3");
    btn3.value = "Show";
    span.style.display = 'none';
}

function btn3Action()
{
    var span = document.getElementById("showOrHideSpan");
    var btn3 = document.getElementById("btn3");
    if(span.style.display == "block")
    {
        btn3.value = "Show";
        span.style.display = 'none';
    }
    else if(span.style.display == 'none')
    {
        btn3.value = "Hide";
        span.style.display = 'block';
    }
}


