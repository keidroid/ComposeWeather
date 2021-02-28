/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package red.torch.composesample.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import red.torch.composesample.data.RepoResult
import kotlin.coroutines.CoroutineContext

interface DogRepository {
    suspend fun getList(): RepoResult<DogListInfo>
    suspend fun getDetail(): RepoResult<DogDetailInfo>
}

data class DogDetailInfo(
    val id: Int,
    val title: String,
    val createdAt: String,
    val location: String,
    val features: String,
    val description: String,
    val owner: String
)

data class DogListInfo(
    val target: String,
    val groups: List<DogListGroup>
) {
    val totalCount: Int
        get() = groups.sumBy { it.dogSimpleInfos.size }
}

data class DogListGroup(
    val label: String,
    val dogSimpleInfos: List<DogSimpleInfo>
)

data class DogSimpleInfo(
    val id: Int,
    val thumbnailUrl: String,
    val title: String,
    val location: String,
    val features: String,
)

class DogRepositoryMock(
    private val coroutineContext: CoroutineContext = Dispatchers.IO
) : DogRepository {
    override suspend fun getList(): RepoResult<DogListInfo> {
        return withContext(coroutineContext) {
            // MOCK: 適当に考えたモックです
            val dogs = DogListInfo(
                target = "東京都",
                groups = listOf(
                    DogListGroup(
                        label = "2021年3月3日",
                        dogSimpleInfos = listOf(
                            DogSimpleInfo(
                                1,
                                "https://torch.red/compose_mock/dog_01.jpg",
                                "ふわふわのコーギー 生後３ヶ月になります。おとなしい性格です。",
                                "東京都 港区",
                                "コーギー・3ヶ月・♀",
                            ),
                            DogSimpleInfo(
                                2,
                                "https://torch.red/compose_mock/dog_02.jpg",
                                "生まれたばかりです。おっとりとした性格でよく寝ます。",
                                "東京都 千代田区",
                                "2ヶ月・♂",
                            ),
                            DogSimpleInfo(
                                3,
                                "https://torch.red/compose_mock/dog_03.jpg",
                                "3/9まで☆白くてふわふわな毛並みです。ワクチン接種済み☆",
                                "東京都 中央区",
                                "2歳・♂",
                            ),
                        ),
                    ),
                    DogListGroup(
                        label = "2021年3月2日",
                        dogSimpleInfos = listOf(
                            DogSimpleInfo(
                                4,
                                "https://torch.red/compose_mock/dog_04.jpg",
                                "イケメンのブランくん。甘えん坊の男の子です。",
                                "東京都 目黒区",
                                "1歳6ヶ月・♂",
                            ),
                            DogSimpleInfo(
                                5,
                                "https://torch.red/compose_mock/dog_05.jpg",
                                "お散歩好きマロンちゃん。家族になってくれる方を募集します。",
                                "東京都 港区",
                                "ダックスフンド・1歳・♂",
                            ),
                            DogSimpleInfo(
                                6,
                                "https://torch.red/compose_mock/dog_06.jpg",
                                "🐶ショコラ🐶3歳去勢済みです。穏やかな性格☆",
                                "東京都 千代田区",
                                "",
                            ),
                            DogSimpleInfo(
                                7,
                                "https://torch.red/compose_mock/dog_07.jpg",
                                "元気いっぱいの双子ちゃんです。優しい方募集します",
                                "東京都",
                                "4ヶ月",
                            ),
                            DogSimpleInfo(
                                8,
                                "https://torch.red/compose_mock/dog_08.jpg",
                                "\uD83D\uDC3E元気いっぱいのカステラくん\uD83D\uDC3Eお菓子大好きの男の子です",
                                "東京都 中央区",
                                "雑種・1歳・♂",
                            ),
                            DogSimpleInfo(
                                9,
                                "https://torch.red/compose_mock/dog_09.jpg",
                                "人なつっこいシュガーくん☆里親さん募集します。関東近郊でお会いできる方",
                                "東京都 渋谷区",
                                "雑種・2歳・♂",
                            ),
                        ),
                    ),
                    DogListGroup(
                        label = "2021年3月1日",
                        dogSimpleInfos = listOf(
                            DogSimpleInfo(
                                10,
                                "https://torch.red/compose_mock/dog_10.jpg",
                                "穏やかな性格のクリームちゃん。キラキラなおめめで見つめてきます",
                                "東京都 北区",
                                "9ヶ月・♀",
                            ),
                            DogSimpleInfo(
                                11,
                                "https://torch.red/compose_mock/dog_11.jpg",
                                "優しい性格のスフレくん。癒やし系の男の子です。",
                                "東京都 港区",
                                "3ヶ月・♂",
                            ),
                            DogSimpleInfo(
                                12,
                                "https://torch.red/compose_mock/dog_12.jpg",
                                "元気いっぱいのリコッタちゃん。家族になってくれる方募集します。",
                                "東京都 台東区",
                                "チワワ・3ヶ月・♀",
                            ),
                        ),
                    ),
                    DogListGroup(
                        label = "2021年2月28日",
                        dogSimpleInfos = listOf(
                            DogSimpleInfo(
                                13,
                                "https://torch.red/compose_mock/dog_13.jpg",
                                "優しくておとなしい性格の男の子です。里親さん募集します。よろしくおねがいします。",
                                "東京都 中野区",
                                "2ヶ月・♂",
                            ),
                            DogSimpleInfo(
                                14,
                                "https://torch.red/compose_mock/dog_14.jpg",
                                "☆里親募集☆元気いっぱいのチワワです。散歩が大好きで食事も大好きです。",
                                "東京都 港区",
                                "チワワ・2歳・♂",
                            ),
                            DogSimpleInfo(
                                15,
                                "https://torch.red/compose_mock/dog_15.jpg",
                                "人懐っこいムースちゃん☆見てくださってありがとうございます。里親を募集します。",
                                "東京都 北区",
                                "2歳・♂",
                            ),
                            DogSimpleInfo(
                                16,
                                "https://torch.red/compose_mock/dog_16.jpg",
                                "人見知りしますがなれると懐いてきてくれます。グルーミング済み",
                                "東京都 目黒区",
                                "1歳3ヶ月・♀",
                            ),
                            DogSimpleInfo(
                                17,
                                "https://torch.red/compose_mock/dog_17.jpg",
                                "\uD83D\uDC36人なつっこい性格です。里親募集します。",
                                "東京都 千代田区",
                                "8ヶ月・♀",
                            ),
                            DogSimpleInfo(
                                18,
                                "https://torch.red/compose_mock/dog_18.jpg",
                                "3/3まで☆白くてもふもふな毛並みです。ワクチン接種済み☆",
                                "東京都 台東区",
                                "11ヶ月・♂",
                            ),
                        ),
                    ),
                    DogListGroup(
                        label = "2021年2月27日",
                        dogSimpleInfos = listOf(
                            DogSimpleInfo(
                                19,
                                "https://torch.red/compose_mock/dog_19.jpg",
                                "おっとりとした性格のもちまるくん。呼ぶとてくてくと歩いてきます。",
                                "東京都 港区",
                                "1歳2ヶ月・♂",
                            ),
                            DogSimpleInfo(
                                20,
                                "https://torch.red/compose_mock/dog_20.jpg",
                                "トイレトレーニング済み☆3月10日まで里親さん募集します。",
                                "東京都 千代田区",
                                "3ヶ月・♂",
                            ),
                        ),
                    ),
                ),
            )
            RepoResult.Success(dogs)
        }
    }

    override suspend fun getDetail(): RepoResult<DogDetailInfo> {
        TODO("Not yet implemented")
    }
}
