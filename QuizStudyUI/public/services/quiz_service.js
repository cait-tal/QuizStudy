import Constants from '../utility/Constants.js';

// Get all quizzes
export function getQuizzes(doc) {
    return $.get(Constants.QUIZ_ENDPOINT);
};
