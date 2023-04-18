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
}