export class TextService{
    isValidText(text:string):boolean{
        if(text!=null){
            return true;
        }
        return false;
    }
}