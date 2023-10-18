const slides = document.querySelectorAll('.slide');
let currentSlide = 0;

function showSlide(n) {
    slides.forEach((slide, index) => {
        slide.style.display = index === n ? 'block' : 'none';
    });
}

function changeSlide(offset) {
    currentSlide = (currentSlide + offset + slides.length) % slides.length;
    showSlide(currentSlide);
}

document.addEventListener('DOMContentLoaded', () => {
    showSlide(currentSlide);
    setInterval(() => changeSlide(1), 4000);
});
