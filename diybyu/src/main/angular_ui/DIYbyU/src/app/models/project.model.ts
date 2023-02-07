export class Project {

     constructor(
            public id: number,
            public dateAdded: number,
            public name: string,
            public timeNeeded: number,
            public material: string,
            public description: string,
            public thumbnail: Image[],
          ) {
            this.name=name;
            this.timeNeeded=timeNeeded;
            this.material=material;
            this.description=description;
            this.thumbnail=thumbnail;
           }
}


export class Image{
  constructor(
      public name: string,
      public lastModified: number,
      public size: number,
      public type: string
  ){}
}
