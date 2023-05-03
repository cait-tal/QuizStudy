import { getQuizzes } from "./services/quiz_service.js";

window.addEventListener('load', loadPage);

function loadPage() {

    let questionBtn = document.querySelector('#question-btn');
    let topicsBtn = document.querySelector('#topic-btn');
    let quizBtn = document.querySelector('#quiz-btn');
    


    questionBtn.addEventListener('click', () => {
        window.location = './questions/questions.html';
    });

    topicsBtn.addEventListener('click', () => {
        window.location = './topics/topics.html';
    });

    quizBtn.addEventListener('click', () => {
        window.location = './quiz/quiz.html';
    });

    let quizzes = getQuizzes(document).then((quizzes) => loadQuizzes(quizzes));
}

function loadQuizzes(quizzes) {
    let container = $(".container");
    console.log(quizzes);
    quizzes = JSON.parse(quizzes);

    for(let q of quizzes) {
        console.log(q);
        let row = document.createElement("div");
        row.className = "container-row";
        let quizName = document.createElement("h2");
        quizName.innerText = q["quiz_name"];

        row.appendChild(quizName);
        container.append(row);        
    }




}