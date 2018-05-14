import {PipeTransform, Pipe} from "@angular/core";

@Pipe({
    name: 'categoriesFormat'
})
export class CategoriesFormatPipe implements PipeTransform {
    transform(categories: any) {
        let list: string = '';
        for (let category of categories) {
            list += '#';
            switch (category) {
                case 'CELEBRITY': {
                    list += 'Celebryci  ';
                    break;
                }
                case 'ANIMAL': {
                    list += 'Zwierzęta  ';
                    break;
                }
                case 'PEOPLE': {
                    list += 'Ludzie  ';
                    break;
                }
                case 'CURIOSITY': {
                    list += 'Ciekawostki  ';
                    break;
                }
                case 'SCIENCE': {
                    list += 'Nauka  ';
                    break;
                }
                case 'FUNNY': {
                    list += 'Śmieszne  ';
                    break
                }
                case 'NATURE': {
                    list += 'Natura  ';
                    break;
                }
                case 'INTERESTING_PLACE': {
                    list += 'Intersujące miejsca  ';
                    break;
                }
                case 'ART': {
                    list += 'Sztuka  ';
                    break;
                }
                case 'MOVIE': {
                    list += 'Film  ';
                    break;
                }
                case 'FASHION': {
                    list += 'Moda  ';
                    break;
                }
                case 'SALE': {
                    list += 'Zakupy  ';
                    break;
                }
                case 'MUSIC': {
                    list += 'Muzyka  ';
                    break;
                }
                case 'CULTURE': {
                    list += 'Kultura  ';
                    break;
                }
                case 'SPORT': {
                    list += 'Sport  ';
                    break;
                }
                case 'WARSZAWA': {
                    list += 'Warszawa  ';
                    break;
                }
                case 'LUBLIN': {
                    list += 'Lublin  ';
                    break;
                }
                case 'POZNAN': {
                    list += 'Poznań  ';
                    break;
                }
                case 'KIELCE': {
                    list += 'Kielce  ';
                    break;
                }
                case 'KATOWICE': {
                    list += 'Katowice  ';
                    break;
                }
                case 'GDANSK': {
                    list += 'Gdańsk  ';
                    break;
                }
                case 'GDYNIA': {
                    list += 'Gdynia  ';
                    break;
                }
                case 'KRAKOW': {
                    list += 'Kraków  ';
                    break;
                }
                case 'WROCLAW': {
                    list += 'Wrocław  ';
                    break;
                }
                default: {
                    list += ' ';
                    break;
                }
            }
        }
        return list;
    }
}
