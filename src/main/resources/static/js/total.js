'use strict';
function calculation() {
    console.log("start");
    let num1 = Number(document.getElementById("score1").innerText);
    let num2 = Number(document.getElementById("score2").innerText);
    let num3 = Number(document.getElementById("score3").innerText);
    let num4 = Number(document.getElementById("score4").innerText);
    let num5 = Number(document.getElementById("score5").innerText);
    let num6 = Number(document.getElementById("score6").innerText);
    let num7 = Number(document.getElementById("score7").innerText);
    let num8 = Number(document.getElementById("score8").innerText);
    let num9 = Number(document.getElementById("score9").innerText);
    let num10 = Number(document.getElementById("score10").innerText);
    let num11 = Number(document.getElementById("score11").innerText);
    let num12 = Number(document.getElementById("score12").innerText);
    let num13 = Number(document.getElementById("score13").innerText);
    let num14 = Number(document.getElementById("score14").innerText);
    let num15 = Number(document.getElementById("score15").innerText);
    let num16 = Number(document.getElementById("score16").innerText);
    let num17 = Number(document.getElementById("score17").innerText);
    let num18 = Number(document.getElementById("score18").innerText);

    let pnum1 = Number(document.getElementById("pat1").innerText);
    let pnum2 = Number(document.getElementById("pat2").innerText);
    let pnum3 = Number(document.getElementById("pat3").innerText);
    let pnum4 = Number(document.getElementById("pat4").innerText);
    let pnum5 = Number(document.getElementById("pat5").innerText);
    let pnum6 = Number(document.getElementById("pat6").innerText);
    let pnum7 = Number(document.getElementById("pat7").innerText);
    let pnum8 = Number(document.getElementById("pat8").innerText);
    let pnum9 = Number(document.getElementById("pat9").innerText);
    let pnum10 = Number(document.getElementById("pat10").innerText);
    let pnum11 = Number(document.getElementById("pat11").innerText);
    let pnum12 = Number(document.getElementById("pat12").innerText);
    let pnum13 = Number(document.getElementById("pat13").innerText);
    let pnum14 = Number(document.getElementById("pat14").innerText);
    let pnum15 = Number(document.getElementById("pat15").innerText);
    let pnum16 = Number(document.getElementById("pat16").innerText);
    let pnum17 = Number(document.getElementById("pat17").innerText);
    let pnum18 = Number(document.getElementById("pat18").innerText);

    let score1 = num1+num2+num3+num4+num5+num6+num7+num8+num9;
    let score2 = num10+num11+num12+num13+num14+num15+num16+num17+num18;
    let score = score1+score2;
    let pat1 = pnum1+pnum2+pnum3+pnum4+pnum5+pnum6+pnum7+pnum8+pnum9;
    let pat2 = pnum10+pnum11+pnum12+pnum13+pnum14+pnum15+pnum16+pnum17+pnum18;
    let pat = pat1+pat2;

    document.getElementById('scoreIn').textContent = score1;
    document.getElementById('scoreOut').textContent = score2;
    document.getElementById('score').textContent = score;
    document.getElementById('patIn').textContent = pat1;
    document.getElementById('patOut').textContent = pat2;
    document.getElementById('pat').textContent = pat;
}

calculation();