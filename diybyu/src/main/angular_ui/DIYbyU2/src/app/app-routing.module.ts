import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent} from './modules/feature/components/home/home.component';
import { AddProjectComponent} from './modules/feature/components/add-project/add-project.component';
import { ViewProjectComponent} from './modules/feature/components/view-project/view-project.component';
import { EditProjectComponent} from './modules/feature/components/edit-project/edit-project.component';

const routes: Routes = [
{path: '', redirectTo: 'projects', pathMatch:'full'},
{path: 'projects', component: HomeComponent},
{path: 'add', component: AddProjectComponent},
{path: 'projects/:id', component: ViewProjectComponent},
{path: 'edit/:id', component: EditProjectComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
