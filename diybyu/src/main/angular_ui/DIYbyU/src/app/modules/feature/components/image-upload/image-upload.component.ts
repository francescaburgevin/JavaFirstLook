import { Component, EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-image-upload',
  templateUrl: './image-upload.component.html',
  styleUrls: ['./image-upload.component.scss']
})
export class ImageUploadComponent implements OnInit {

  @Output() imageUploadEvent = new EventEmitter<any>();

  public selectedFile: File = new File([], "");

  constructor() { }

  ngOnInit(): void {
  }

  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
    this.imageUploadEvent.emit(this.selectedFile);
  }

}