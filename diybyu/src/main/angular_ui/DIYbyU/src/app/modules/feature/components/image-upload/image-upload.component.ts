import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {FileUploadModule} from 'primeng/fileupload';
import { Image } from "../../../../models/project.model";

@Component({
  selector: 'app-image-upload',
  templateUrl: './image-upload.component.html',
  styleUrls: ['./image-upload.component.scss']
})
export class ImageUploadComponent implements OnInit {

  @Output() imageUploadEvent = new EventEmitter<any>();


  fileName: string = '';
  public picture: Image = new Image("", 0, 0, "");
  public selectedFile: File = new File([], "");
  public imagePreview: any = "";
  //public formData: FormData = new FormData();


  constructor() { }

  ngOnInit(): void {
  }

  /*
   public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
      if (this.selectedFile) {
          this.onUpload();
        }
}

  //Gets called when the user clicks on submit to upload the image
  onUpload() {
    this.imageUploadEvent.emit(this.selectedFile);
  }
}
*/

onUpload(event: any) {
  this.picture.name = event.files[0].name;
  this.picture.lastModified = event.files[0].lastModified;
  this.picture.size = event.files[0].size;
  this.picture.type = event.files[0].type;
  //this.newUser.common.avatar.push(this.picture);

  this.selectedFile = event.files[0];
  /*
  const reader = new FileReader();
      reader.onload = () => {
          this.imagePreview = reader.result;
      }
  reader.readAsDataURL(this.selectedFile);
*/
}

/*

changeFileName(name: string){
    let fileFormat = name.split(".").pop();
    let timeStamp = new Date().getTime().toString();
    return timeStamp+"."+fileFormat;
  }

  s
*/
}