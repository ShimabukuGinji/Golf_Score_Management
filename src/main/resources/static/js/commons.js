'use strict';
function openModal() {
    let modal = document.getElementById('modal');
    let gray_out = document.getElementById("fadeLayer");
    gray_out.style.visibility = "visible";
    setTimeout(addClass, 200);
}

function closeModal() {
    let modal = document.getElementById('modal');
    let gray_out = document.getElementById("fadeLayer");
    modal.classList.remove('is-show');
    gray_out.style.visibility ="hidden";
}

function addClass() {
    let modal = document.getElementById('modal');
    modal.classList.add('is-show');
}

function calculation() {
    console.log("start");
    let num1 = Number(document.getElementById("score1").value);
    let num2 = Number(document.getElementById("score2").value);
    let num3 = Number(document.getElementById("score3").value);
    let num4 = Number(document.getElementById("score4").value);
    let num5 = Number(document.getElementById("score5").value);
    let num6 = Number(document.getElementById("score6").value);
    let num7 = Number(document.getElementById("score7").value);
    let num8 = Number(document.getElementById("score8").value);
    let num9 = Number(document.getElementById("score9").value);
    let num10 = Number(document.getElementById("score10").value);
    let num11 = Number(document.getElementById("score11").value);
    let num12 = Number(document.getElementById("score12").value);
    let num13 = Number(document.getElementById("score13").value);
    let num14 = Number(document.getElementById("score14").value);
    let num15 = Number(document.getElementById("score15").value);
    let num16 = Number(document.getElementById("score16").value);
    let num17 = Number(document.getElementById("score17").value);
    let num18 = Number(document.getElementById("score18").value);

    let pnum1 = Number(document.getElementById("pat1").value);
    let pnum2 = Number(document.getElementById("pat2").value);
    let pnum3 = Number(document.getElementById("pat3").value);
    let pnum4 = Number(document.getElementById("pat4").value);
    let pnum5 = Number(document.getElementById("pat5").value);
    let pnum6 = Number(document.getElementById("pat6").value);
    let pnum7 = Number(document.getElementById("pat7").value);
    let pnum8 = Number(document.getElementById("pat8").value);
    let pnum9 = Number(document.getElementById("pat9").value);
    let pnum10 = Number(document.getElementById("pat10").value);
    let pnum11 = Number(document.getElementById("pat11").value);
    let pnum12 = Number(document.getElementById("pat12").value);
    let pnum13 = Number(document.getElementById("pat13").value);
    let pnum14 = Number(document.getElementById("pat14").value);
    let pnum15 = Number(document.getElementById("pat15").value);
    let pnum16 = Number(document.getElementById("pat16").value);
    let pnum17 = Number(document.getElementById("pat17").value);
    let pnum18 = Number(document.getElementById("pat18").value);

    let score1 = num1+num2+num3+num4+num5+num6+num7+num8+num9;
    let score2 = num10+num11+num12+num13+num14+num15+num16+num17+num18;
    let score = score1+score2;
    let pat1 = pnum1+pnum2+pnum3+pnum4+pnum5+pnum6+pnum7+pnum8+pnum9;
    let pat2 = pnum10+pnum11+pnum12+pnum13+pnum14+pnum15+pnum16+pnum17+pnum18;
    let pat = pat1+pat2;

    document.getElementById('score1-9').textContent = score1;
    document.getElementById('score10-18').textContent = score2;
    document.getElementById('score').textContent = score;
    document.getElementById('pat1-9').textContent = pat1;
    document.getElementById('pat10-18').textContent = pat2;
    document.getElementById('pat').textContent = pat;
}

function back() {
    history.back();
}

document.getElementById('select').addEventListener('change', () => {
    const courseId = document.getElementById('select').value
    fetch(`/course-per?courseId=${courseId}`)
    .then(res => {
        res.json()
            .then(data => {
            document.getElementById('par_hole1').textContent = data.parHole1;
            document.getElementById('par_hole2').textContent = data.parHole2;
            document.getElementById('par_hole3').textContent = data.parHole3;
            document.getElementById('par_hole4').textContent = data.parHole4;
            document.getElementById('par_hole5').textContent = data.parHole5;
            document.getElementById('par_hole6').textContent = data.parHole6;
            document.getElementById('par_hole7').textContent = data.parHole7;
            document.getElementById('par_hole8').textContent = data.parHole8;
            document.getElementById('par_hole9').textContent = data.parHole9;
            document.getElementById('par_hole10').textContent = data.parHole10;
            document.getElementById('par_hole11').textContent = data.parHole11;
            document.getElementById('par_hole12').textContent = data.parHole12;
            document.getElementById('par_hole13').textContent = data.parHole13;
            document.getElementById('par_hole14').textContent = data.parHole14;
            document.getElementById('par_hole15').textContent = data.parHole15;
            document.getElementById('par_hole16').textContent = data.parHole16;
            document.getElementById('par_hole17').textContent = data.parHole17;
            document.getElementById('par_hole18').textContent = data.parHole18;

        })
    })
});

