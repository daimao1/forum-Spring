import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
    name: 'shorterContent'
})
export class ShorterContentPipe implements PipeTransform {
    transform(value: any) {
        if (value.length >= 200) {
            return value.substr(0, 200) + ' ...';
        }
        return value;

    }
}
