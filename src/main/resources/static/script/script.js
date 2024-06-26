var onda1 = document.getElementById('onda1');
var onda2 = document.getElementById('onda2');
var onda3 = document.getElementById('onda3');
var onda4 = document.getElementById('onda4');

window.addEventListener('scroll', function(){
    var rolagemPos = window.scrollY

    onda1.style.backgroundPositionX = 400 + rolagemPos * 4 + 'px';
    onda2.style.backgroundPositionX = 300 + rolagemPos * -4 + 'px';
    onda3.style.backgroundPositionX = 200 + rolagemPos * 2 + 'px';
    onda4.style.backgroundPositionX = 100 + rolagemPos * -2 + 'px';
    
})

const faqs = document.querySelectorAll('.faq');

faqs.forEach(faq => {
    faq.addEventListener('click', () => {
        faq.classList.toggle('active');
    })
})


/* Login e Cadastro */

const loginForm = document.getElementById('loginForm');
const signupForm = document.getElementById('signupForm');
const showSignupBtn = document.getElementById('showSignup');
const showLoginBtn = document.getElementById('showLogin');


showSignupBtn.addEventListener('click', () => {
    loginForm.classList.add('hidden');
    signupForm.classList.remove('hidden');
});

showLoginBtn.addEventListener('click', () => {
    loginForm.classList.remove('hidden');
    signupForm.classList.add('hidden');
});

/* Login e Cadastro */
