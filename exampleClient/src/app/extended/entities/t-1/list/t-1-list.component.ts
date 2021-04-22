import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { MatDialog } from '@angular/material';

import { Router, ActivatedRoute } from '@angular/router';

import { T1ExtendedService } from '../t-1.service';
import { T1NewExtendedComponent } from '../new/t-1-new.component';
import { Globals, PickerDialogService, ErrorService } from 'src/app/common/shared';

import { T1ListComponent } from 'src/app/entities/t-1/index';

@Component({
  selector: 'app-t-1-list',
  templateUrl: './t-1-list.component.html',
  styleUrls: ['./t-1-list.component.scss'],
})
export class T1ListExtendedComponent extends T1ListComponent implements OnInit {
  title: string = 'T1';
  constructor(
    public router: Router,
    public route: ActivatedRoute,
    public global: Globals,
    public dialog: MatDialog,
    public changeDetectorRefs: ChangeDetectorRef,
    public pickerDialogService: PickerDialogService,
    public t1Service: T1ExtendedService,
    public errorService: ErrorService
  ) {
    super(router, route, global, dialog, changeDetectorRefs, pickerDialogService, t1Service, errorService);
  }

  ngOnInit() {
    super.ngOnInit();
  }

  addNew() {
    super.addNew(T1NewExtendedComponent);
  }
}
