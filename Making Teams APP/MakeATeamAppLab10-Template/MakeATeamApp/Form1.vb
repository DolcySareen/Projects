Option Strict On
Imports System.IO

Public Class Form1
    Dim teams As Team() = New Team(9) {}  ' An array of Team objects
    Private teamCount As Integer = 0      ' The number of Teams added to teams()
    Dim ofd As OpenFileDialog = New OpenFileDialog

    Private allPositions As String() = {"Centre", "Forward", "Defense", "Goalie", "Roamer"}
    Private allDivisions As String() = {"Premier", "Division 1", "Division 2", "Division 3", "Novice"}



    Private Sub MakeATeamFRM_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        populateComboBox(leagueCBO, allDivisions)
        populateComboBox(pos1CBO, allPositions)
        ' Populate the other three ComboBoxes (pos2CBX, pos3CBX, pos4CBX) here
        populateComboBox(pos2CBO, allPositions)
        populateComboBox(pos3CBO, allPositions)
        populateComboBox(pos4CBO, allPositions)
        ClearTextBoxes()
        loadBTN.Enabled = False
    End Sub

    Private Sub makeTeamBTN_Click(sender As Object, e As EventArgs) Handles makeTeamBTN.Click
        Dim players As Player() = New Player(3) {}
        Dim teamName As String = teamNameTBX.Text
        Dim league As String = leagueCBO.Text

        If name1TBX.Text.Equals("") And name1TBX.Text.Equals("") And name1TBX.Text.Equals("") And name1TBX.Text.Equals("") Then
            MessageBox.Show("You must specify at least one player for your team.", "Invalid Team")
        Else

            ' Create player objects, players(0), players(1), players(2), players(3).  
            ' Only create Player(i) if the player's associated TextBox is not empty.
            If Not name1TBX.Text.Equals("") Then players(0) = New Player(name1TBX.Text, pos1CBO.Text, dob1DTP.Value)
            If Not name2TBX.Text.Equals("") Then players(1) = New Player(name2TBX.Text, pos2CBO.Text, dob2DTP.Value)
            If Not name3TBX.Text.Equals("") Then players(2) = New Player(name3TBX.Text, pos3CBO.Text, dob3DTP.Value)
            If Not name4TBX.Text.Equals("") Then players(3) = New Player(name4TBX.Text, pos4CBO.Text, dob4DTP.Value)

            teams(teamCount) = New Team(teamName, league, players)
            teamCount = teamCount + 1
            teamLBX.Items.Add(teamName)
            If teamCount = 10 Then makeTeamBTN.Enabled = False
            ClearTextBoxes()
        End If
    End Sub

    Sub populateComboBox(cbx As ComboBox, sa As String()) ' DO NOT MODIFY
        For i = 0 To sa.GetUpperBound(0)
            cbx.Items.Add(sa(i))
        Next
    End Sub

    Private Sub teamLBX_SelectedIndexChanged(sender As Object, e As EventArgs) Handles teamLBX.SelectedIndexChanged
        ' DO NOT MODIFY Procedure
        Dim teamIndex As Integer = teamLBX.SelectedIndex
        outTBX.Text = teams(teamIndex).TeamSummary
    End Sub

    Private Sub ClearTextBoxes() ' DO NOT MODIFY Procedure
        name1TBX.Text = ""
        name2TBX.Text = ""
        name3TBX.Text = ""
        name4TBX.Text = ""
        teamNameTBX.Text = ""
    End Sub

    Private Sub name1TBX_TextChanged(sender As Object, e As EventArgs) Handles name1TBX.TextChanged

    End Sub

    Private Sub BrowseBTN_Click(sender As Object, e As EventArgs) Handles browseBTN.Click
        Dim dr As DialogResult = ofd.ShowDialog()
        Dim fName = ofd.FileName
        If dr <> DialogResult.Cancel Then
            fileNameTBX.Text = fName
        End If
        loadBTN.Enabled = True

    End Sub

    Private Sub LoadBTN_Click(sender As Object, e As EventArgs) Handles loadBTN.Click
        teamLBX.Items.Clear()
        teamCount = 0
        Dim fName = fileNameTBX.Text
        If Not File.Exists(fName) Then
            MessageBox.Show("The file ' " & fName & "' does not exist", "Invalid File Name ", MessageBoxButtons.OK, MessageBoxIcon.Hand)
        Else
            Dim sr As StreamReader = New StreamReader(fileNameTBX.Text)
            Dim team As String = ""
            Dim d1 As Date
            Dim datearr As String()
            Dim teamArray As String()
            Dim noOfPlayers As Integer
            Dim size As Integer
            Dim playerArray As Player()
            Do Until sr.EndOfStream
                team = sr.ReadLine()
                teamArray = team.Split(","c)
                size = (teamArray.Length - 2)
                noOfPlayers = CInt(size / 3)
                If noOfPlayers = 1 Then
                    playerArray = New Player(0) {}
                    datearr = teamArray(3).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player1 As Player = New Player(teamArray(2), teamArray(4), d1)
                    playerArray(0) = player1
                    teams(teamCount) = New Team(teamArray(0), teamArray(1), playerArray)
                ElseIf noOfPlayers = 2 Then
                    playerArray = New Player(1) {}
                    datearr = teamArray(3).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player1 As Player = New Player(teamArray(2), teamArray(4), d1)
                    playerArray(0) = player1
                    datearr = teamArray(6).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player2 As Player = New Player(teamArray(5), teamArray(7), d1)
                    playerArray(1) = player2
                    teams(teamCount) = New Team(teamArray(0), teamArray(1), playerArray)
                ElseIf noOfPlayers = 3 Then
                    playerArray = New Player(2) {}
                    datearr = teamArray(3).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player1 As Player = New Player(teamArray(2), teamArray(4), d1)
                    playerArray(0) = player1
                    datearr = teamArray(6).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player2 As Player = New Player(teamArray(5), teamArray(7), d1)
                    playerArray(1) = player2
                    datearr = teamArray(9).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player3 As Player = New Player(teamArray(8), teamArray(10), d1)
                    playerArray(2) = player3
                    teams(teamCount) = New Team(teamArray(0), teamArray(1), playerArray)
                ElseIf noOfPlayers = 4 Then
                    playerArray = New Player(3) {}
                    datearr = teamArray(3).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player1 As Player = New Player(teamArray(2), teamArray(4), d1)
                    playerArray(0) = player1
                    datearr = teamArray(6).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player2 As Player = New Player(teamArray(5), teamArray(7), d1)
                    playerArray(1) = player2
                    datearr = teamArray(9).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player3 As Player = New Player(teamArray(8), teamArray(10), d1)
                    playerArray(2) = player3
                    datearr = teamArray(12).Split("/"c)
                    d1 = New Date(CInt(datearr(2)), CInt(datearr(0)), CInt(datearr(1)))
                    Dim player4 As Player = New Player(teamArray(11), teamArray(13), d1)
                    playerArray(3) = player4
                    teams(teamCount) = New Team(teamArray(0), teamArray(1), playerArray)
                End If


                teamCount = teamCount + 1
                teamLBX.Items.Add(teamArray(0))


            Loop
        End If
    End Sub

    Private Sub fileNameTBX_TextChanged(sender As Object, e As EventArgs) Handles fileNameTBX.TextChanged
        If fileNameTBX.Text.Equals("") Then
            loadBTN.Enabled = False
        Else
            loadBTN.Enabled = True
        End If
    End Sub
End Class
