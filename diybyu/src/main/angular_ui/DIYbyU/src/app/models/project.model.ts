export class Project {

     constructor(
            public id: number,
            public dateAdded: number,
            public name: string,
            public timeNeeded: number,
            public material: string,
            public description: string,
            public thumbnail: string,
          ) {
            this.name=name;
            this.timeNeeded=timeNeeded;
            this.material=material;
            this.description=description;
            this.thumbnail=thumbnail;
           }
}

export class ProjectList {

    constructor(
    ) { }
}
