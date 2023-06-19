import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { HeaderComponent } from './modules/core/components/header/header.component';
import { FooterComponent } from './modules/core/components/footer/footer.component';
import { NavbarComponent } from './modules/core/components/navbar/navbar.component';

import { HomeComponent } from './modules/feature/components/home/home.component';
import { AddProjectComponent } from './modules/feature/components/add-project/add-project.component';
import { EditProjectComponent } from './modules/feature/components/edit-project/edit-project.component';
import { ViewProjectComponent } from './modules/feature/components/view-project/view-project.component';
import { ProjectCardComponent } from './modules/feature/components/project/project-card/project-card.component';
import { ProjectListComponent } from './modules/feature/components/project/project-list/project-list.component';
import { SearchBarComponent } from './modules/feature/components/search-bar/search-bar.component';
import { ImageUploadComponent } from './modules/feature/components/image-upload/image-upload.component';

import { FileUploadModule } from 'primeng/fileupload';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    NavbarComponent,
    HomeComponent,
    AddProjectComponent,
    EditProjectComponent,
    ViewProjectComponent,
    ProjectCardComponent,
    ProjectListComponent,
    SearchBarComponent,
    ImageUploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    FileUploadModule,
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
