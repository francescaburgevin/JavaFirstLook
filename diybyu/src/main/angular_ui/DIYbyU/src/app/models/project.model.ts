export class Project {

     constructor(
            public id: number,
            public dateAdded: string,
            public name: string,
            public timeNeeded: number,
            public material: string,
            public description: string,
            public imageFileCode: ""
          ) {
            this.name=name;
            this.timeNeeded=timeNeeded;
            this.material=material;
            this.description=description;
            this.imageFileCode=imageFileCode;
           }
}