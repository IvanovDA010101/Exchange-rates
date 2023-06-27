const randomGifUrl = "http://localhost:8082/random"
const ratesUrl = "http://localhost:8082/rates"
const gifUrl ="http://api.giphy.com/v1/gifs/"
const api = "AgjrysW190ZUnz8MsBF4Z6iPIQjwBGd1"
let rates;

getOtherRate();
async function getRandomGif() {
    const dataJson = await fetch(randomGifUrl).then(response=> response.json())
        .then(data =>{ return data});
    console.log(dataJson);
    console.log(dataJson.id);
    getGif(dataJson.id);
}

async function getGif(code){
    link = gifUrl + code+ "?" + "api_key=" + api;
    const dataJson = await fetch(link).then(response =>{ return response.json()});
    const img = document.createElement('img');
    console.log(dataJson);
    img.src = dataJson.data.images.original.url;
    const container = document.querySelector('#image-container');
    if (container.children[0]){
    container.children[0].remove();}
    container.insertAdjacentElement("afterbegin",img);
}

async function getRates(){
    const dataJson = await fetch(ratesUrl).then(response =>{ return response.text()});
    console.log(dataJson);
    const answer = JSON.parse(dataJson);
    rates=dataJson;
    const out = document.querySelector('.rates'); // находим div

    out.innerHTML =''; // очищаем его
    for (key in answer) {    //перебираем объект
        out.innerHTML += '<div id="'+key+'">'+key+"="+answer[key]+'</div>';

    }
}
async function getOtherRate(){
    const dataJson = await fetch(ratesUrl).then(response =>{ return response.text()});
    console.log(dataJson);
    const answer = JSON.parse(dataJson);
    const out = document.querySelector('#otherRate'); // находим div
    out.innerHTML =''; // очищаем его
    out.innerHTML="RUB = "+answer["RUB"];
}

function readProperty(){
    let file=new FileReader();

}
