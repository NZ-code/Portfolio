export class Colors {
    static colors: string[] = [ '#633636', '#366353','#634936', '#1B3229','#633657',
                        '#1B3224', '#1E1B32', 
                        '#291B32', '#1B2932','#292326'
                        ]
    static getRandomColor():string{
        const randomIndex = Math.floor(Math.random() * this.colors.length);
        return this.colors[randomIndex];
    }
    static getColorById(index:number):string{
        return this.colors[index % this.colors.length];
    }
}
