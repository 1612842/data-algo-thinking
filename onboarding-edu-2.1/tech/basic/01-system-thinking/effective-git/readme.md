# branching 
### Main branches
Gồm hai branh chính với vòng đời vô hạn:
 - master
 - develop

![main-branches_2x](extra/main-branches@2x.png)

Trong đó `origin/master` là nhánh chính, tại branh này HEAD của source code luôn ở trạng thái `production-ready`.

Với nhánh `develop`, HEAD của source code luôn phản ánh trạng thái là các thay đổi mới nhất cho bản release tiếp theo. 

Khi các thay đổi ở nhánh `develop` hoàn thiện và có thể release thì nên được merge vào nhánh `master` và tạo `tag version`.

### Các nhánh hỗ trợ
Bên cạnh các nhánh chính, có các nhánh hỗ trợ phát triển song song giữa các thành viên nhóm, dễ dàng theo dõi các tính năng, chuẩn bị cho bản release và hỗ trợ hotfix. Các nhánh này có thời gian tồn tại giới hạn, sẽ được xóa khi merge vào các nhánh khác.

- Feature branches
- Release branches
- Hotfix branches

Những branh này có những vai trò riêng và có quy tắc nghiêm nhặt: nhánh này được tách ra từ nhánh nào, và sẽ được merge vào nhánh nào.

-------------

<b>Nhánh Feature:

Được tách ra từ nhánh: `develop`

Sẽ được merge vào nhánh: `develop`

Cách đặt tên: Tên bất kì trừ `master`, `develop`, `release-*`, or `hotfix-*`, nên có prefix là `feature-`

![fb_2x](extra/fb@2x.png)

Là nhánh dùng để phát triền các features mới sẽ được release trong version tiếp theo hoặc trong tương lai. Nhánh này tồn tại khi feature vẫn còn được phát triển và sẽ được merge vào nhánh develop hoặc feature này ngừng phát triển do không cần nữa, thử nghiệm thất bại.

- Tạo mới feature
```bash
$ git checkout -b feature-myfeature develop
Switched to a new branch "feature-myfeature"
```

- Hoàn thành feature
```bash 
$ git checkout develop
Switched to branch 'develop'
$ git merge --no-ff myfeature
Updating ea1b82a..05e9557
(Summary of changes)
$ git branch -d myfeature
Deleted branch myfeature (was 05e9557).
$ git push origin develop
```
Tag `--no-ff` giúp tránh việc mất đi lịch sử các commit trên nhánh feature

--------------

<b> Nhánh release

Được tách ra từ nhánh: `develop`

Sẽ được merge vào nhánh: `develop` and `master`

Cách đặt tên: `release-*`

Là nhánh chuẩn bị cho production release, dùng để fix các lỗi nhỏ và chuẩn bị các meta-data cho release (version number, build date, ..). Bằng việc xử lý trên nhánh này mà nhánh develop sẵn sàng nhận các feature mới cho các release tiếp theo.

Tại thời điểm nhánh release được tạo từ nhánh develop thì ít nhất tất cả feature cho bản release phải được merge vào nhánh develop tại thời điểm tạo nhánh và tất cả feature được tag cho bản release tiếp theo phải chờ đến khi nhánh release này được tạo xong, lúc đó nhánh develop sẵn sàng để nhận các feature cho next release.

Trong thời gian test, qc test, ... cho bản release này, các fix bug sẽ được commit lên nhánh này thay vì nhánh develop. Sau khi bản release sẵn sàng cho production thì nhánh release sẽ được merger vào master và tạo tag. Cuối cùng thì các commit fix bugs sẽ được merge vào nhánh develop để bản release tiếp theo không đụng phải các bugs này.

- Tạo nhánh release
```
$ git checkout -b release-1.2 develop
Switched to a new branch "release-1.2"
$ ./bump-version.sh 1.2
Files modified successfully, version bumped to 1.2.
$ git commit -a -m "Bumped version number to 1.2"
[release-1.2 74d9424] Bumped version number to 1.2
1 files changed, 1 insertions(+), 1 deletions(-)
```
`./bump-version.sh` script để thay đổi một số file chứa version number.

- Hoàn thành release

``` bash 
# Merge to master
$ git checkout master
Switched to branch 'master'
$ git merge --no-ff release-1.2
Merge made by recursive.
(Summary of changes)
$ git tag -a 1.2


# Merge to develop
$ git checkout develop
Switched to branch 'develop'
$ git merge --no-ff release-1.2

# Remove branh
$ git branch -d release-1.2

```

--------------

<b> Hot fix

Được tách ra từ nhánh: `master`

Sẽ được merge vào nhánh: `develop` and `master`

Cách đặt tên: `hotfix-*`

![hotfix-branches_2x](extra/hotfix-branches@2x.png)

Nhánh này cũng giống nhánh release nhưng chỉ sử dụng trong các trường hợp cần fix lỗi nhanh trên môi trường production. 

Khi có lỗi cần fix, nhánh hot fix được tạo trên tag mà production đang chạy. fix bug sẽ được commit trên nhánh này, sau đó được merge lại `master` và `develop`.

- Tạo nhánh hotfix
```bash 
$ git checkout -b hotfix-1.2.1 master
Switched to a new branch "hotfix-1.2.1"
$ ./bump-version.sh 1.2.1
Files modified successfully, version bumped to 1.2.1.
$ git commit -a -m "Bumped version number to 1.2.1"
[hotfix-1.2.1 41e61bb] Bumped version number to 1.2.1
```

- Hoàn thành hotfix

```bash 
# Merge to master
$ git checkout master
Switched to branch 'master'
$ git merge --no-ff hotfix-1.2.1
Merge made by recursive.
(Summary of changes)
$ git tag -a 1.2.1

# Merge to develop
$ git checkout develop
Switched to branch 'develop'
$ git merge --no-ff hotfix-1.2.1
Merge made by recursive.
```


-----------------



# Commit 


### Quy định về commit code
**mỗi commit nên đảm bảo các yếu tố sau**:
- Commit chỉ nên chứa các thay đổi liên quan đến nhau, và đảm bảo số thay đổi ở mức nhỏ nhất. Những thay đổi không liên quan trong commit đó thì chuyển thành commit khác.

- Cố gắng tạo càng nhiều commit càng tốt, có thể là các local commit để lưu lại các thay đổi nếu chưa muốn push lên server.

- Commit message rõ ràng, phản ánh tóm tắt các thay đổi có trong commit

- Commit message nếu gặp khó khăn khi diễn đạt bằng tiếng Anh, có thể diễn đạt bằng tiếng Việt có dấu.

- Commit message theo format sau (quy định ở dưới)

### Khi nào thì commit code
Hãy commit sớm và thường xuyên

Commit có thể thực hiện khi có bất cứ thay đổi nào: 

- Commit thay đổi về căn dòng
- Commit đổi tên file
- Commit code đang chưa build được
- Commit các tests chưa hoàn thành
- Commit các code thử nghiệm
  ..v..v..

Mọi thứ có thể commit, chỉ cần nhớ, khi commit thì ghi message rõ ràng về commit đó.
Các commit có thể thực hiện local sau đó đây lên một lượt, hoặc commit trực tiếp.

### Commit message
Một commit cần chứa một message có ý nghĩa, và cần làm rõ được những câu hỏi sau:

| Câu hỏi | Mô tả |
|---------|-------|
| Why is this change necessary? | This question tells reviewers what to expect in the commit, allowing them to more easily identify and point out unrelated changes. |
| How does it address the issue? | Describe, at a high level, what was done to affect change. _Introduce a red/black tree to increase search speed or Remove <troublesome gem X>, which was causing <specific description of issue introduced by gem>_ are good examples. |
| What side effects does this change have? | This is the most important question to answer, as it can point out problems where you are making too many changes in one commit or branch. One or two bullet points for related changes may be okay, but five or six are likely indicators of a commit that is doing too many things. |

Commit mesage nên theo format sau:
<pre>
[SCOPE] Short description

Long description to describe the changes
</pre>

Ví dụ:
<pre>
[Consul] Bỏ không sử dụng consul, config service list
Lấy danh sách service thông qua config thay vì sử dụng consul, do consul thường bị lỗi khi get service. Việc này không anh hưởng tới các thành phần khác trong messenger.
</pre>


--------------------



# Review Code
## Tiêu chí khi thực hiện review code
Người thực hiện review code thực hiện đánh giá trên các tiêu chí sau:
- Các thay đổi trong source code là đúng theo yêu cầu đặt ra

- Các thay đổi không làm ảnh hưởng xấu tới các phần khác

- Các thay đổi phù hợp với style, coding convention hiện tại

- Có unit test hay chưa

- Unit test có cover được hết các trường hợp hay chưa


### Tạo merge request
Code review có thể thực hiện khi một merge request được tạo.

Merge reques tạo cần note đầy đủ các thông tin: 
- Đưa ra mô tả chính xác và rõ ràng về các thay đổi, tại sao cần thiết có những thay đổi này.

- Phạm vi thay đổi.

- Chỗ nào mà người review có thể muốn đặc biệt chú ý ?

- Chi tiết mà có thể giúp người review hiểu rõ các vấn đề.

Người review vào merge request xem code, có thể thấy được các thay đổi:

|  |               |
| --------- | ------------------------ |
| Mọi người có thể review thay đổi ở tab `Changes` | ![Screenshot_Changes](extra/26.png) |
| Mọi người có thể `Comment` trực tiếp trên code | ![Screenshot_Comment](extra/05.png) |
| Sau khi comment phần comment đó sẽ được add vào tab `Discussion` và member đang làm feature sẽ cập nhật lại theo comment | ![Screenshot_Discussion](extra/01.png) |


Khi tất cả discus được resolve và code được fix thì merge request sẽ được merge vào đích.

