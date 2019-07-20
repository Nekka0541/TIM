Option Explicit
Dim fso 'Scripting.FileSystemObject
Dim f 'Scripting.File
Dim args
Dim f_name
Dim add_txt

With WScript
'Arguments=コマンドライン引数
  Set args = .Arguments
'args.Countを1以上にするには、ファイルをvbsにドラッグして起動する必要がある。
  If args.Count < 1 Then .Quit
  add_txt = InputBox("ファイル名に付加する文字列を入力してください。")
'入力がなければQuit
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
      MsgBox "ファイル名に使えない文字が指定されたので中断します。"
      Exit For
    Case 58
      MsgBox add_txt & f.Name & " は既に存在するためファイル名を変更できません。"
      .Clear
    Case 0
      'エラーが発生しなかった場合は何もしない
    Case Else
      MsgBox .Description & .Number
      .Clear
  End Select
  End With

Next

Set f = Nothing
Set fso = Nothing