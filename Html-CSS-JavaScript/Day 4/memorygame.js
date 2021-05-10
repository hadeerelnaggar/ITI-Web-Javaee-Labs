let cardArray = [
    { name: "bird", img: "bird.jpg", },
    { name: "bird", img: "bird.jpg", },
    { name: "dog", img: "dog.jpg", },
    { name: "dog", img: "dog.jpg", },
    { name: "fish", img: "fish.jpg", },
    { name: "fish", img: "fish.jpg", },
    { name: "giraffe", img: "girraffe.jpg", },
    { name: "giraffe", img: "girraffe.jpg", },
    { name: "potato", img: "potato.jpg", },
    { name: "potato", img: "potato.jpg", },
    { name: "plant", img: "plant.jpg", },
    { name: "plant", img: "plant.jpg", },
];

let grid = document.querySelector(".grid");
let score = document.querySelector(".scoreBoard");
let clickBoard = document.querySelector(".clickBoard");

let imgs;
let cardsId = [];
let cardsSelected = [];
let cardsWon = 0;

document.addEventListener("DOMContentLoaded", function () {
    //define functions 

    createBoard(grid, cardArray);
    arrangeCard();
    //add a click function for images 

    imgs = document.querySelectorAll("img");
    Array.from(imgs).forEach(img =>
        img.addEventListener("click", flipCard)
    )
});

function createBoard(grid, array) {
    array.forEach((arr, index) => {
        let img = document.createElement("img");
        img.setAttribute("src", "back.png");
        img.setAttribute("data-id", index);
        grid.appendChild(img);
    })
}

function arrangeCard() {
    cardArray.sort(() => 0.5 - Math.random())
}

function flipCard() {
    let selected = this.dataset.id;
    cardsSelected.push(cardArray[selected].name);
    cardsId.push(selected);
    this.classList.add("flip");
    this.setAttribute("src", cardArray[selected].img);
    if (cardsId.length === 2) {
        setTimeout(checkForMatch, 500);
    }
}

function checkForMatch() {
    let imgs = document.querySelectorAll("img");
    let firstCard = cardsId[0];
    let secondCard = cardsId[1];
    if (cardsSelected[0] === cardsSelected[1] && firstCard !== secondCard) {
        // alert("you have found a match"); 
        cardsWon += 1;
        score.innerHTML = cardsWon;
        setTimeout(checkWon, 500)
    } else {
        imgs[firstCard].setAttribute("src", "back.png");
        imgs[secondCard].setAttribute("src", "back.png");
        imgs[firstCard].classList.remove("flip"); imgs[secondCard].classList.remove("flip");
    }
    cardsSelected = [];
    cardsId = [];
    // clicks += 1; 
    // clickBoard.innerHTML = clicks; 
}

function checkWon() {
    if (cardsWon == cardArray.length / 2) {
        alert("You won")
        setTimeout(300);
    }
}

function replay() {
    arrangeCard();
    grid.innerHTML = "";
    createBoard(grid, cardArray);
    cardsWon = 0;
    // clicks = 0;
    // clickBoard.innerHTML = 0;
    score.innerHTML = 0;
}