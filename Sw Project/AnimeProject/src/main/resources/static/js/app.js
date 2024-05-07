const arrows = document.querySelectorAll(".arrow");
const movieListContainers = document.querySelectorAll(".movie-list-container");

arrows.forEach((arrow, i) => {
  const movieList = movieListContainers[i].querySelector(".movie-list");
  const itemNumber = movieList.querySelectorAll("img").length;
  let clickCounter = 0;

  arrow.addEventListener("click", () => {
    const ratio = Math.floor(window.innerWidth / 270);
    clickCounter++;
    if (itemNumber - (4 + (clickCounter-(i+1))) + (4 - (ratio-(i+1))) >= 0) {
      movieList.style.transform = `translateX(${
        movieList.getBoundingClientRect().left - 300
      }px)`;
    } else {
      movieList.style.transform = "translateX(0)";
      clickCounter = 0;
    }
  });

  console.log(Math.floor(window.innerWidth / 270));
});

// TOGGLE

const ball = document.querySelector(".toggle-ball");
const items = document.querySelectorAll(
  ".container,.movie-list-title,.navbar-container,.sidebar, .sidebar i,.toggle"
);

ball.addEventListener("click", () => {
  items.forEach((item) => {
    item.classList.toggle("active");
  });
  ball.classList.toggle("active");
});
