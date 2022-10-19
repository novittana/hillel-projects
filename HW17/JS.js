// ЗАДАНИЕ
// Сделать валидацию для вашей формы
// 1. Имя (Длина 2 - 20 только английские)
// 2. Емейл проверить что там длина 6 -12 символов(англиские) до @ и потом почта gmail.com или ukr.net
// 3. Мобильный телефон 380 + 50|63|66|67|68|91|92|93|97| 96 + 7 digits

// В итоге мы должны получить alert c сообщением "Мы услышим вас" или "Мы вас не слышим"


// КОММЕНТАРИИ К РЕШЕНИЮ
// в моей форме еще есть фамиллия - валидация как в имени



document.querySelector("#btn-send").onclick = function formValid () {

let firstName = document.querySelector("#firstName").value;
let surName = document.querySelector("#surname").value;
let tel = document.querySelector("#tel").value;
let mail = document.querySelector("#e-mail").value;

let reg = /^[a-zA-Z]{2,20}$/;
let reg2 = /^(380)(50|63|66|67|68|91|92|93|97|96)\d{7}$/
let reg3 = /^[a-zA-Z]{6,12}@(gmail\.com|ukr\.net)$/;


let result = reg.test(firstName)&&reg.test(surName)&&reg2.test(tel)&&reg3.test(mail)

if (result) {
	alert ("Мы услышим вас");
} else {
	alert ("Мы вас не слышим");
}

}


