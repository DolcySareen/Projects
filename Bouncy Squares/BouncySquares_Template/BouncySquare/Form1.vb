Option Strict On
Public Class Form1
    Dim xDirection As Integer = 1
    Dim yDirection As Integer = 1
    Dim xLocation As Integer = 0
    Dim yLocation As Integer = 0
    Dim stepCount As Integer = 1
    Const width As Integer = 51   ' The number of columns
    Const height As Integer = 23  ' The number of rows
    Private Sub BouncyAppFRM_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        slowRBN.Checked = True
        outTBX.Text = ""
    End Sub

    Sub drawSquare(size As Integer, x As Integer, y As Integer)
        Dim s As String = ""
        For row = 0 To height - 1
            For col = 0 To width - 1

                If row >= y AndAlso row < y + size AndAlso col >= x AndAlso col < x + size Then
                    s &= "X"
                Else
                    s &= " "
                End If
            Next
            s = s & vbNewLine
        Next
        outTBX.Text = s
    End Sub

    Private Sub runBTN_Click(sender As Object, e As EventArgs) Handles runBTN.Click

        'bounceTMR.Enabled = True
        drawSquare(CInt(sizeNUD.Value), xLocation, yLocation)
        If runBTN.Text.Equals("Pause") Then
            runBTN.Text = "Run"
            bounceTMR.Enabled = False
        Else
            runBTN.Text = "Pause"
            bounceTMR.Enabled = True
        End If
    End Sub

    Private Sub sizeNUD_ValueChanged(sender As Object, e As EventArgs) Handles sizeNUD.ValueChanged, stepNUD.ValueChanged, slowRBN.CheckedChanged _
           , fastRBN.CheckedChanged, turboRBN.CheckedChanged

        drawSquare(CInt(sizeNUD.Value), xLocation, yLocation)

    End Sub

    Private Sub bounceTMR_Tick(sender As Object, e As EventArgs) Handles bounceTMR.Tick
        xLocation = xLocation + xDirection
        yLocation = yLocation + yDirection
        If slowRBN.Checked Then
            bounceTMR.Interval = 500
        ElseIf fastRBN.Checked Then
            bounceTMR.Interval = 200
        Else
            bounceTMR.Interval = 50
        End If
        If xDirection = 1 Then
            xLocation += 1
            If stepCount = 0 Then
                yLocation += 1
                stepCount = CInt(stepNUD.Value)

            Else
                stepCount = stepCount - 1
            End If
        End If

        If xLocation >= width - CInt(sizeNUD.Value) Then
            xDirection = -1
        End If
        If yLocation >= height - CInt(sizeNUD.Value) Then
            yDirection = -1
        End If
        If xLocation = (0) Then
            xDirection = 1
        End If
        If yLocation = (0) Then
            yDirection = 1
        End If
        drawSquare(CInt(sizeNUD.Value), xLocation, yLocation)


    End Sub
End Class
