Option Explicit
Dim fso 'Scripting.FileSystemObject
Dim f 'Scripting.File
Dim args
Dim f_name
Dim add_txt

With WScript
'Arguments=�R�}���h���C������
  Set args = .Arguments
'args.Count��1�ȏ�ɂ���ɂ́A�t�@�C����vbs�Ƀh���b�O���ċN������K�v������B
  If args.Count < 1 Then .Quit
  add_txt = InputBox("�t�@�C�����ɕt�����镶�������͂��Ă��������B")
'���͂��Ȃ����Quit
  If Len(add_txt) = 0 Then .Quit
End With

Set fso = CreateObject("Scripting.FileSystemObject")

On Error Resume Next

For Each f_name in args

  set f = fso.GetFile(f_name)
  f.Name = add_txt & f.Name

  With Err
  Select Case .Number
    Case 5, 52
      MsgBox "�t�@�C�����Ɏg���Ȃ��������w�肳�ꂽ�̂Œ��f���܂��B"
      Exit For
    Case 58
      MsgBox add_txt & f.Name & " �͊��ɑ��݂��邽�߃t�@�C������ύX�ł��܂���B"
      .Clear
    Case 0
      '�G���[���������Ȃ������ꍇ�͉������Ȃ�
    Case Else
      MsgBox .Description & .Number
      .Clear
  End Select
  End With

Next

Set f = Nothing
Set fso = Nothing