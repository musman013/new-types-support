import { Component, OnInit, Inject } from '@angular/core';
import { T1ExtendedService } from '../t-1.service';

import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder } from '@angular/forms';
import { Globals, PickerDialogService, ErrorService } from 'src/app/common/shared';
import { MatDialogRef, MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';

import { T1NewComponent } from 'src/app/entities/t-1/index';

@Component({
  selector: 'app-t-1-new',
  templateUrl: './t-1-new.component.html',
  styleUrls: ['./t-1-new.component.scss'],
})
export class T1NewExtendedComponent extends T1NewComponent implements OnInit {
  title: string = 'New T1';
  constructor(
    public formBuilder: FormBuilder,
    public router: Router,
    public route: ActivatedRoute,
    public dialog: MatDialog,
    public dialogRef: MatDialogRef<T1NewComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any,
    public global: Globals,
    public pickerDialogService: PickerDialogService,
    public t1ExtendedService: T1ExtendedService,
    public errorService: ErrorService
  ) {
    super(
      formBuilder,
      router,
      route,
      dialog,
      dialogRef,
      data,
      global,
      pickerDialogService,
      t1ExtendedService,
      errorService
    );
  }

  ngOnInit() {
    super.ngOnInit();
  }
}
